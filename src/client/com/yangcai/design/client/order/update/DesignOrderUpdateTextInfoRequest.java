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
package com.yangcai.design.client.order.update;

import com.yangcai.design.client.YangcaiClientRequest;

public class DesignOrderUpdateTextInfoRequest extends YangcaiClientRequest<DesignOrderUpdateTextInfoResponse>
{
//  数据类型                   字段名           非空       数据长度        字段描述
    private long                merchantId;//     是
    private long                designId;//       是
    
    private String              userText;//        否        4000
    private String              userNotice;//      否        1000
    private String              userMobile;//      否        64
    private String              userQq;//          否        64
    private String              userWx;//          否        64
    public String getMethod()
    {
        return ORDER_UPDATE_TEXT_INFO;
    }

    public DesignOrderUpdateTextInfoResponse newResponse()
    {
        return new DesignOrderUpdateTextInfoResponse();
    }

    protected void buildQueryBody()
    {
        addParam("merchantId", merchantId);
        addParam("designId", designId);
        addParam("userText", userText);
        addParam("userNotice", userNotice);
        addParam("userMobile", userMobile);
        addParam("userQq", userQq);
        addParam("userWx", userWx);
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

    public String getUserText()
    {
        return userText;
    }

    public void setUserText(String userText)
    {
        this.userText = userText;
    }

    public String getUserNotice()
    {
        return userNotice;
    }

    public void setUserNotice(String userNotice)
    {
        this.userNotice = userNotice;
    }

    public String getUserMobile()
    {
        return userMobile;
    }

    public void setUserMobile(String userMobile)
    {
        this.userMobile = userMobile;
    }

    public String getUserQq()
    {
        return userQq;
    }

    public void setUserQq(String userQq)
    {
        this.userQq = userQq;
    }

    public String getUserWx()
    {
        return userWx;
    }

    public void setUserWx(String userWx)
    {
        this.userWx = userWx;
    }
}
