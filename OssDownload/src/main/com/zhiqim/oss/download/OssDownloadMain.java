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
import java.util.List;

import org.zhiqim.kernel.Global;
import org.zhiqim.kernel.Servicer;
import org.zhiqim.kernel.logging.Log;
import org.zhiqim.kernel.logging.LogFactory;
import org.zhiqim.kernel.util.Urls;
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
        do
        {
            long t1 = System.currentTimeMillis();
            objectListing = service.getObjectListing(bucketName, prefix_dir, marker, 1000);
            long t2 = System.currentTimeMillis();
            System.out.println("第["+page+"]获取共用["+(t2 - t1)+"]毫秒");
            List<OSSObjectSummary> tlist = objectListing.getObjectSummaries();
            marker = objectListing.getNextMarker();
            List<OssFile> listFiles = new ArrayList<>();
            for (OSSObjectSummary ossFile : tlist)
            {
                ++size;
                String fileKey = ossFile.getKey();
                String ossPrefix = prefix_dir;
                String ossDir = fileKey.replaceFirst(prefix_dir, "").substring(0, fileKey.lastIndexOf("/"));
                String fileName = fileKey.substring(fileKey.lastIndexOf("/")+1);
                int downloadFlag = 0;
                System.out.println(ossDir);
                
                OssFile osFile = new OssFile();
                osFile.setDownloadFlag(downloadFlag);
                osFile.setFileKey(fileKey);
                osFile.setFileName(fileName);
                osFile.setOssDir(ossDir);
                osFile.setOssPrefix(ossPrefix);
                osFile.setFileIndex(size);
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
                ORM.get(ZTable.class).replaceBatch(listFiles);
            }
            
            page++;
        }
        while (objectListing != null && objectListing.isTruncated() && page <=2);
        return false;
    }
}
