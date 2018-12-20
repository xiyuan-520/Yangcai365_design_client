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
package com.yangcai.design.client;

import org.zhiqim.kernel.json.Jsons;

/****
 * 文件对象
 *
 * @version v1.0.0 @author longguizhi 2018-12-1 新建与整理
 */
public class ApiFile
{
    private long        designId;          //1设计订单号         
    private long        attaId;            //2附件编号           
    private String      attaModule;        //3附件类型
    private String      fileName;          //4文件名，接口请求必须字段
    private String      fileExt;           //5文件后缀名 ，接口请求必须字段
    private long        fileSize;          //6文件大小，接口请求必须字段
    private String      downUrl;           //7下载地址，接口请求必须字段
    
    public long getDesignId()
    {
        return designId;
    }
    public void setDesignId(long designId)
    {
        this.designId = designId;
    }
    public long getAttaId()
    {
        return attaId;
    }
    public void setAttaId(long attaId)
    {
        this.attaId = attaId;
    }
    public String getAttaModule()
    {
        return attaModule;
    }
    public void setAttaModule(String attaModule)
    {
        this.attaModule = attaModule;
    }
    public String getFileName()
    {
        return fileName;
    }
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
    public String getFileExt()
    {
        return fileExt;
    }
    public void setFileExt(String fileExt)
    {
        this.fileExt = fileExt;
    }
    public long getFileSize()
    {
        return fileSize;
    }
    public void setFileSize(long fileSize)
    {
        this.fileSize = fileSize;
    }
    public String getDownUrl()
    {
        return downUrl;
    }
    public void setDownUrl(String downUrl)
    {
        this.downUrl = downUrl;
    }
    
    public String toString()
    {
        return Jsons.toString(this);
    }
}
