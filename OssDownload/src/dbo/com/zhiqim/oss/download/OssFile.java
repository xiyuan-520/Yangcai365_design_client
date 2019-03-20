/*
 * 版权所有 (C) 2015 知启蒙(ZHIQIM) 保留所有权利。
 *
 * 指定登记&发行网站： https://www.zhiqim.com/ 欢迎加盟知启蒙，[编程有你，知启蒙一路随行]。
 *
 * 由数据库字典自动生成的类文件，修改请使用数据库字典编辑器修改。
 */
package com.zhiqim.oss.download;

import java.io.Serializable;

import org.zhiqim.kernel.annotation.AnAlias;
import org.zhiqim.kernel.annotation.AnNew;
import org.zhiqim.kernel.json.Jsons;
import org.zhiqim.orm.annotation.*;

/**
 * oss文件信息 对应表《OSS_FILE》
 */
@AnAlias("OssFile")
@AnNew
@AnTable(table="OSS_FILE", key="FILE_KEY", type="InnoDB")
@AnIndex({@AnIndexValue(name="IX_DOWNLOAD_FLAG", column="DOWNLOAD_FLAG", unique=false),
          @AnIndexValue(name="IX_FILE_INDEX", column="FILE_INDEX", unique=false),
          @AnIndexValue(name="IX_OSS_URL", column="OSS_URL", unique=false)})
public class OssFile implements Serializable
{
    private static final long serialVersionUID = 1L;

    @AnTableField(column="FILE_KEY", type="string,400", notNull=true)    private String fileKey;    //1.ossKEY
    @AnTableField(column="OSS_PREFIX", type="string,400", notNull=false)    private String ossPrefix;    //2.前缀路径
    @AnTableField(column="OSS_DIR", type="string,400", notNull=true)    private String ossDir;    //3.oss目录
    @AnTableField(column="FILE_NAME", type="string,400", notNull=false)    private String fileName;    //4.文件名
    @AnTableField(column="OSS_URL", type="string,2000", notNull=false)    private String ossUrl;    //5.OSS 访问路径
    @AnTableField(column="DOWNLOAD_FLAG", type="int", notNull=true)    private int downloadFlag;    //6.下载标志 0 未下载 1 已下载
    @AnTableField(column="OSS_MARKER", type="string,400", notNull=false)    private String ossMarker;    //7.oss MARKER
    @AnTableField(column="FILE_INDEX", type="int", notNull=true)    private int fileIndex;    //8.FILE_INDEX

    public String toString()
    {
        return Jsons.toString(this);
    }

    public String getFileKey()
    {
        return fileKey;
    }

    public void setFileKey(String fileKey)
    {
        this.fileKey = fileKey;
    }

    public String getOssPrefix()
    {
        return ossPrefix;
    }

    public void setOssPrefix(String ossPrefix)
    {
        this.ossPrefix = ossPrefix;
    }

    public String getOssDir()
    {
        return ossDir;
    }

    public void setOssDir(String ossDir)
    {
        this.ossDir = ossDir;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getOssUrl()
    {
        return ossUrl;
    }

    public void setOssUrl(String ossUrl)
    {
        this.ossUrl = ossUrl;
    }

    public int getDownloadFlag()
    {
        return downloadFlag;
    }

    public void setDownloadFlag(int downloadFlag)
    {
        this.downloadFlag = downloadFlag;
    }

    public String getOssMarker()
    {
        return ossMarker;
    }

    public void setOssMarker(String ossMarker)
    {
        this.ossMarker = ossMarker;
    }

    public int getFileIndex()
    {
        return fileIndex;
    }

    public void setFileIndex(int fileIndex)
    {
        this.fileIndex = fileIndex;
    }

}
