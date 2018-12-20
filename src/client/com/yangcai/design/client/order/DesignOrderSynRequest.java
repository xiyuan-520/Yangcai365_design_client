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
package com.yangcai.design.client.order;

import com.yangcai.design.client.YangcaiClientRequest;

public class DesignOrderSynRequest extends YangcaiClientRequest<DesignOrderSynResponse>
{
    private long               merchantId;//           是                            订单商户编号
    private long                 designId;//           否                            设计订单号
    private long                    outId;//           否                            外部系统单号
    private String          startModifyTime;//      否                            设计平台的订单开始变更时间，默认十分钟前
    private String          endModifyTime;//        否                            设计平台的订单结束时间，默认当前时间
    public String getMethod()
    {
        return ORDER_SYN;
    }

    public DesignOrderSynResponse newResponse()
    {
        return new DesignOrderSynResponse();
    }

    protected void buildSignBody()
    {
        addParam("merchantId", merchantId);
        addParam("designId", designId);
        addParam("outId", outId);
        addParam("startModifyTime", startModifyTime);
        addParam("endModifyTime", endModifyTime);
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

    public long getOutId()
    {
        return outId;
    }

    public void setOutId(long outId)
    {
        this.outId = outId;
    }

    public String getStartModifyTime()
    {
        return startModifyTime;
    }

    public void setStartModifyTime(String startModifyTime)
    {
        this.startModifyTime = startModifyTime;
    }

    public String getEndModifyTime()
    {
        return endModifyTime;
    }

    public void setEndModifyTime(String endModifyTime)
    {
        this.endModifyTime = endModifyTime;
    }
    
}
