/*
 * 版权所有 (C) 2015 知启蒙(ZHIQIM) 保留所有权利。
 * 
 * 指定登记&发行网站： https://www.zhiqim.com/ 欢迎加盟知启蒙，[编程有你，知启蒙一路随行]。
 *
 * 本文采用《知启蒙许可证》，除非符合许可证，否则不可使用该文件！
 * 1、您可以免费使用、修改、合并、出版发行和分发，再授权软件、软件副本及衍生软件；
 * 2、您用于商业用途时，必须在原作者指定的登记网站，按原作者要求进行登记；
 * 3、您在使用、修改、合并、出版发行和分发时，必须包含版权声明、许可声明，及保留原作者的著作权、商标和专利等知识产权；
 * 4、您在互联网、移动互联网等大众网络下发行和分发再授权软件、软件副本及衍生软件时，必须在原作者指定的发行网站进行发行和分发；
 * 5、您可以在以下链接获取一个完整的许可证副本。
 * 
 * 许可证链接：http://zhiqim.org/licenses/zhiqim_register_publish_license.htm
 * 
 * 除非法律需要或书面同意，软件由原始码方式提供，无任何明示或暗示的保证和条件。详见完整许可证的权限和限制。
 */
package com.zhiqim.oss.download;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zhiqim.kernel.Global;
import org.zhiqim.kernel.Servicer;
import org.zhiqim.kernel.logging.Log;
import org.zhiqim.kernel.logging.LogFactory;
import org.zhiqim.kernel.util.Urls;
import org.zhiqim.kernel.util.Validates;
import org.zhiqim.orm.ORM;
import org.zhiqim.orm.ZTable;
import org.zhiqim.orm.dbo.Selector;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.zhiqim.oss.service.OssServer;
import com.zhiqim.oss.service.oss.OssService;

public class OssDownloadMain extends Servicer
{
    private static Log log = LogFactory.getLog(OssDownloadMain.class);
    private static String bucketName = Global.getString("oss", "bucketName");
    private static String prefix_dir = Global.getString("oss", "prefix_dir", "");
    private static boolean isInternal = "true".equalsIgnoreCase(Global.getString("oss", "isInternal")) ? true : false;
    public boolean create() throws Exception
    {
        OssService service = Global.get(OssService.class);
        OssServer server = service.getServer();
        int size = 0;
        int page = 1;
        OssFile item = ORM.get(ZTable.class).item(OssFile.class, new Selector("fileKey,ossMarker,fileIndex").addMustIsNotNull("ossMarker").addOrderbyDesc("fileIndex"));
        String marker = item == null ? null : item.getOssMarker();
        size = item == null ? 0 : item.getFileIndex();
        ObjectListing objectListing = null;
        Map<String, Integer> dirSize = new HashMap<>();
        int pageSize = 1000;
        do
        {
            long t1 = System.currentTimeMillis();
            objectListing = service.getObjectListing(bucketName, prefix_dir, marker, pageSize);
            List<OSSObjectSummary> tlist = objectListing.getObjectSummaries();
            marker = objectListing.getNextMarker();//必须标记否则查询到相同数据
            List<OssFile> listFiles = new ArrayList<>();
            for (OSSObjectSummary ossFile : tlist)
            {
                ++size;
                
                String fileKey = ossFile.getKey();
                String ossPrefix = prefix_dir;
                String ossDir = fileKey.replaceFirst(prefix_dir, "");
                ossDir= ossDir.substring(0, ossDir.lastIndexOf("/"));
                String fileName = fileKey.substring(fileKey.lastIndexOf("/")+1);
                int downloadFlag = 0;
                OssFile osFile = new OssFile();
                osFile.setDownloadFlag(downloadFlag);
                osFile.setFileKey(fileKey);
                osFile.setFileName(fileName);
                osFile.setOssPrefix(ossPrefix);
                osFile.setFileIndex(size);
                osFile.setOssDir(ossDir);
                String ossFirstDir = null;
                if (ossDir.indexOf("/") == -1)
                    ossFirstDir = ossDir;
                else
                    ossFirstDir = ossDir.substring(0, ossDir.indexOf("/"));
                
                
                Integer cout = dirSize.get(ossFirstDir);
                cout = cout == null ? 1 : cout+1;
                dirSize.put(ossFirstDir, cout);
                
//                osFile.setOssMarker(marker);
                //http://yangcai-taobao.oss-cn-shenzhen.aliyuncs.com/00000000/mnt/taobao/%E5%AA%92%E4%BD%93%E7%B4%A0%E6%9D%90/canvas/1712291243403505/imp_1801081745119667.jpg
                OSSClient ossClient = null;
                try
                {
                    ossClient = new OSSClient(server.getEndpointExternal(), server.getAccessKeyId(), server.getAccessKeySecret());
                    String ossUrl = service.getAccessUrl(bucketName, fileKey, ossClient);
                    osFile.setOssUrl(ossUrl);
                    service.getAccessUrl(bucketName, fileKey, ossClient);
                }
                catch (Exception ce)
                {
                }
                finally
                {
                    if (ossClient != null) 
                        ossClient.shutdown();
                }
                
                listFiles.add(osFile);
            }
            
            if (listFiles.size() != 0)
            {
                
                listFiles.get(listFiles.size() - 1).setOssMarker(marker);
                for (OssFile ossFile2 : listFiles)
                {
                    OssFile ss = ORM.get(ZTable.class).item(OssFile.class, ossFile2.getFileKey());
                    if (ss == null)
                        ORM.get(ZTable.class).insert(ossFile2);
                }
               
                System.out.println("第["+page+"]处理共用["+(System.currentTimeMillis() - t1)+"]毫秒");
                log.info("已录入数据[%s]条 其中 %s", size, getInfo(dirSize));
            }
            
            page++;
        }
        while (objectListing != null && objectListing.isTruncated());
        
        
        log.info("文件获取完成 共[%s]条 其中 %s", size, getInfo(dirSize));
        return false;
    }
    
    private String getInfo(Map<String, Integer> dataMap)
    {
        StringBuilder sb = new StringBuilder();
        for (String key : dataMap.keySet())
        {
            String str = !Validates.isEmptyBlank(sb.toString()) ? ""  : ", ["+key+"]["+dataMap.get(key)+"]条";
            sb.append(str);
        }
        return sb.toString();
    }
    
    public static void main(String[] args)
    {
        System.out.println("00000000/mnt/taobao/媒体素材/canvas/1712200931488598/imp_1801041512360558.jpg".getBytes().length);
    }
}
