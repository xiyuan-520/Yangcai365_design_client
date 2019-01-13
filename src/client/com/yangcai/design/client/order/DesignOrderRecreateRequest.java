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

/****
 * 订单创建请求
 * @version v1.0.0 @author lgz 2019-1-12 新建与整理
 */
public class DesignOrderRecreateRequest extends YangcaiClientRequest<DesignOrderRecreateResponse>
{
//           数据类型                               字段名           是否为空       数据长度          字段描述
    //       数据类型                   字段名           是否为空       数据长度        字段描述 
    private long               merchantId;//           是                            订单商户编号
    private long                 newOutId;//           是                            第三方新订单号
    private long              designSrcId;//           是                            设计平台原订单号。
    private String          redesignReason;//           否             300           重新设计原因 

    public String getMethod()
    {
        return ORDER_RE_CREATE;
    }

    public DesignOrderRecreateResponse newResponse()
    {
        return new DesignOrderRecreateResponse();
    }

    protected void buildQueryBody()
    {
        addParam("merchantId", merchantId);
        addParam("newOutId", newOutId);
        addParam("designSrcId", designSrcId);
        addParam("redesignReason", redesignReason);
    }

    public long getMerchantId()
    {
        return merchantId;
    }

    public void setMerchantId(long merchantId)
    {
        this.merchantId = merchantId;
    }

    public long getNewOutId()
    {
        return newOutId;
    }

    public void setNewOutId(long newOutId)
    {
        this.newOutId = newOutId;
    }

    public long getDesignSrcId()
    {
        return designSrcId;
    }

    public void setDesignSrcId(long designSrcId)
    {
        this.designSrcId = designSrcId;
    }

    public String getRedesignReason()
    {
        return redesignReason;
    }

    public void setRedesignReason(String redesignReason)
    {
        this.redesignReason = redesignReason;
    }
}
