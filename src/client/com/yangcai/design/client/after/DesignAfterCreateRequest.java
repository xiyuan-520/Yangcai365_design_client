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

import java.util.List;

import org.zhiqim.kernel.json.Jsons;

import com.yangcai.design.client.YangcaiApiFile;
import com.yangcai.design.client.YangcaiClientRequest;

/***
 * 售后同步请求
 *
 * @version v1.0.0 @author lgz 2018-12-22 新建与整理
 */
public class DesignAfterCreateRequest extends YangcaiClientRequest<DesignAfterCreateResponse>
{
    //       字段类型                   接口字段              长度             是否必须           字段描述
    private long                     merchantId;//                            是               商户标号
    private long                       designId;//                             是               那条设计订单 出的售后
    private long                    newDesignId;//                             是               那条设计订单 出的售后
    private String                      outAfsId;//            64               是               第三方售后单号
    private String                   problemDesc;//           300               是               问题描述
    private double                   lossAmount;
    private List<YangcaiApiFile>       apiFiles;//                             否               售后文件
    public String getMethod()
    {
        return AFTER_CREATE;
    }

    public DesignAfterCreateResponse newResponse()
    {
        return new DesignAfterCreateResponse();
    }

    protected void buildQueryBody()
    {
        addParam("merchantId", merchantId);
        addParam("designId", designId);
        addParam("outAfsId", outAfsId);
        addParam("problemDesc", problemDesc);
        addParam("newDesignId", newDesignId);
        addParam("lossAmount", lossAmount);
        addParam("aipFiles", Jsons.toString(apiFiles));
    }

    public long getMerchantId()
    {
        return merchantId;
    }

    public void setMerchantId(long merchantId)
    {
        this.merchantId = merchantId;
    }

    public long getDesignId()
    {
        return designId;
    }

    public void setDesignId(long designId)
    {
        this.designId = designId;
    }

    public String getOutAfsId()
    {
        return outAfsId;
    }

    public void setOutAfsId(String outAfsId)
    {
        this.outAfsId = outAfsId;
    }

    public String getProblemDesc()
    {
        return problemDesc;
    }

    public void setProblemDesc(String problemDesc)
    {
        this.problemDesc = problemDesc;
    }

    public long getNewDesignId()
    {
        return newDesignId;
    }

    public void setNewDesignId(long newDesignId)
    {
        this.newDesignId = newDesignId;
    }

    public double getLossAmount()
    {
        return lossAmount;
    }

    public void setLossAmount(double lossAmount)
    {
        this.lossAmount = lossAmount;
    }

    public List<YangcaiApiFile> getApiFiles()
    {
        return apiFiles;
    }

    public void setApiFiles(List<YangcaiApiFile> apiFiles)
    {
        this.apiFiles = apiFiles;
    }

}
