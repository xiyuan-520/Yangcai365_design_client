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
package com.yangcai.design.client.after;

import java.sql.Timestamp;
import java.util.List;

import org.zhiqim.kernel.json.Jsons;

import com.yangcai.design.client.YangcaiApiFile;


/***
 * 设计是平台 售后订单 相应
 * TODO：类功能介绍
 *
 * @version v1.0.0 @author longguizhi 2018-12-15 新建与整理
 */
public class DesignAfter
{
    private long                designId;           //那条设计订单 出的售后
    private long                designAfsId;        //设计盘平台的售后单号
    private int                 afterStatus;        //处理状态
    private long                problemType;        //问题类型
    private String              problemDesc;        //问题描述
    private Timestamp            createTime; 
    private Timestamp            modifyTime; 
    private long                 merchantId;
    private String                 outAfsId;
    private String   designerComplainReason;        //设计师申诉原因
    private String         designReturnNote;        //设计师申诉原因
    private String          afterFinishNote;        //售后完成备注
    
    private List<YangcaiApiFile> apiFiles;
    public long getDesignId()
    {
        return designId;
    }
    public void setDesignId(long designId)
    {
        this.designId = designId;
    }
    public long getDesignAfsId()
    {
        return designAfsId;
    }
    public void setDesignAfsId(long designAfsId)
    {
        this.designAfsId = designAfsId;
    }
    public int getAfterStatus()
    {
        return afterStatus;
    }
    public void setAfterStatus(int afterStatus)
    {
        this.afterStatus = afterStatus;
    }
    public long getProblemType()
    {
        return problemType;
    }
    public void setProblemType(long problemType)
    {
        this.problemType = problemType;
    }
    public String getProblemDesc()
    {
        return problemDesc;
    }
    public void setProblemDesc(String problemDesc)
    {
        this.problemDesc = problemDesc;
    }
    public Timestamp getCreateTime()
    {
        return createTime;
    }
    public void setCreateTime(Timestamp createTime)
    {
        this.createTime = createTime;
    }
    public Timestamp getModifyTime()
    {
        return modifyTime;
    }
    public void setModifyTime(Timestamp modifyTime)
    {
        this.modifyTime = modifyTime;
    }
    public long getMerchantId()
    {
        return merchantId;
    }
    public void setMerchantId(long merchantId)
    {
        this.merchantId = merchantId;
    }
    public String getOutAfsId()
    {
        return outAfsId;
    }
    public void setOutAfsId(String outAfsId)
    {
        this.outAfsId = outAfsId;
    }
    public List<YangcaiApiFile> getApiFiles()
    {
        return apiFiles;
    }
    public void setApiFiles(List<YangcaiApiFile> apiFiles)
    {
        this.apiFiles = apiFiles;
    }
    public String getDesignerComplainReason()
    {
        return designerComplainReason;
    }
    public void setDesignerComplainReason(String designerComplainReason)
    {
        this.designerComplainReason = designerComplainReason;
    }
    public String getDesignReturnNote()
    {
        return designReturnNote;
    }
    public void setDesignReturnNote(String designReturnNote)
    {
        this.designReturnNote = designReturnNote;
    }
    public String getAfterFinishNote()
    {
        return afterFinishNote;
    }
    public void setAfterFinishNote(String afterFinishNote)
    {
        this.afterFinishNote = afterFinishNote;
    }
    public String toString()
    {
        return Jsons.toString(this);
    }
}
