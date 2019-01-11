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

/****
 * 
 * 订单规格修改
 * @version v1.0.0 @author lgz 2019-1-10 新建与整理
 */
public class DesignOrderUpdateSpecificationRequest extends YangcaiClientRequest<DesignOrderUpdateSpecificationResponse>
{
    //  数据类型                   字段名           是否为空       数据长度        字段描述
    
    
    private long                 designId;//           是                            设计订单编号
    private long               merchantId;//           是                            订单商户编号
    private String               orderText;//           否              200             产品全称，最多200个字符
    private String              afterNames;//           否              500              后加工 多个逗号隔开
    private String            printSpecial;//           否              100             特殊工艺，最多100个字符
    private double                  amount;//          否                              金额最多支持两位小数
    private boolean               isUrgent;//          是                           是否加急，。
    private int                  draftType;//          是                            稿件类型，0:自来稿，1:改稿自来稿，2:普通设计,3:高级设计
    private long                industryId;//          是                            行业编号，由设计平台提供，业务方适配。
    private double             designWidth;//          是                           设计宽度，单位mm，最多两位小数，含出血
    private double            designHeight;//          是                              设计高度，单位mm，最多两位小数，含出血
    private int                 designPage;//          是                            设计面数，单面为1，双面为2
    private double              printWidth;//          否                              特殊尺寸宽度，单位mm，最多两位小数, 不含出血(用户尺寸)
    private double             printHeight;//          否                              特殊尺寸高度，单位mm，最多两位小数, 不含出血(用户尺寸)
    private int                    printKs;//          是                            设计款数
    private int                    printMs;//          是                            设计模数
    private String             userContact;//           否             30               联系人 
    private String              userMobile;//           是              20              联系电话
    private String               buyerNick;//           否              100             买家昵称
    private String                  userQq;//           否              20              买家联系QQ
    private String                  userWx;//           否              20              买家联系微信号
    private String         servicesMessage;//           否             500              留言给设计师
    public String getMethod()
    {
        return ORDER_UPDATE_SPECIFICATION;
    }

    public DesignOrderUpdateSpecificationResponse newResponse()
    {
        return new DesignOrderUpdateSpecificationResponse();
    }

    protected void buildQueryBody()
    {
        
        addParam("designId", designId);//  
        addParam("merchantId",  merchantId);
        addParam("orderText", orderText); 
        addParam("afterNames", afterNames); 
        addParam("printSpecial", printSpecial); 
        addParam("amount", amount); 
        addParam("isUrgent", isUrgent); 
        addParam("draftType", draftType); 
        addParam("industryId", industryId); 
        addParam("designWidth", designWidth); 
        addParam("designHeight", designHeight); 
        addParam("designPage", designPage); 
        addParam("printWidth", printWidth); 
        addParam("printHeight", printHeight); 
        addParam("printKs", printKs); 
        addParam("printMs", printMs); 
        addParam("userContact", userContact); 
        addParam("userMobile", userMobile); 
        addParam("buyerNick", buyerNick); 
        addParam("userQq", userQq); 
        addParam("userWx", userWx); 
        addParam("servicesMessage", servicesMessage); 
    }

    public long getDesignId()
    {
        return designId;
    }

    public void setDesignId(long designId)
    {
        this.designId = designId;
    }

    public long getMerchantId()
    {
        return merchantId;
    }

    public void setMerchantId(long merchantId)
    {
        this.merchantId = merchantId;
    }

    public String getOrderText()
    {
        return orderText;
    }

    public void setOrderText(String orderText)
    {
        this.orderText = orderText;
    }

    public String getAfterNames()
    {
        return afterNames;
    }

    public void setAfterNames(String afterNames)
    {
        this.afterNames = afterNames;
    }

    public String getPrintSpecial()
    {
        return printSpecial;
    }

    public void setPrintSpecial(String printSpecial)
    {
        this.printSpecial = printSpecial;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public boolean isUrgent()
    {
        return isUrgent;
    }

    public void setUrgent(boolean isUrgent)
    {
        this.isUrgent = isUrgent;
    }

    public int getDraftType()
    {
        return draftType;
    }

    public void setDraftType(int draftType)
    {
        this.draftType = draftType;
    }

    public long getIndustryId()
    {
        return industryId;
    }

    public void setIndustryId(long industryId)
    {
        this.industryId = industryId;
    }

    public double getDesignWidth()
    {
        return designWidth;
    }

    public void setDesignWidth(double designWidth)
    {
        this.designWidth = designWidth;
    }

    public double getDesignHeight()
    {
        return designHeight;
    }

    public void setDesignHeight(double designHeight)
    {
        this.designHeight = designHeight;
    }

    public int getDesignPage()
    {
        return designPage;
    }

    public void setDesignPage(int designPage)
    {
        this.designPage = designPage;
    }

    public double getPrintWidth()
    {
        return printWidth;
    }

    public void setPrintWidth(double printWidth)
    {
        this.printWidth = printWidth;
    }

    public double getPrintHeight()
    {
        return printHeight;
    }

    public void setPrintHeight(double printHeight)
    {
        this.printHeight = printHeight;
    }

    public int getPrintKs()
    {
        return printKs;
    }

    public void setPrintKs(int printKs)
    {
        this.printKs = printKs;
    }

    public int getPrintMs()
    {
        return printMs;
    }

    public void setPrintMs(int printMs)
    {
        this.printMs = printMs;
    }

    public String getUserContact()
    {
        return userContact;
    }

    public void setUserContact(String userContact)
    {
        this.userContact = userContact;
    }

    public String getUserMobile()
    {
        return userMobile;
    }

    public void setUserMobile(String userMobile)
    {
        this.userMobile = userMobile;
    }

    public String getBuyerNick()
    {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick)
    {
        this.buyerNick = buyerNick;
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

    public String getServicesMessage()
    {
        return servicesMessage;
    }

    public void setServicesMessage(String servicesMessage)
    {
        this.servicesMessage = servicesMessage;
    }
}
