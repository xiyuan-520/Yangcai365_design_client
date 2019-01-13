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

import java.util.List;
import org.zhiqim.kernel.json.Jsons;
import com.yangcai.design.client.YangcaiApiFile;
import com.yangcai.design.client.YangcaiClientRequest;

/****
 * 订单创建请求
 * @version v1.0.0 @author lgz 2019-1-12 新建与整理
 */
public class DesignOrderCreateRequest extends YangcaiClientRequest<DesignOrderCreateResponse>
{
//           数据类型                               字段名           是否为空       数据长度          字段描述
    private long                              merchantId;//         是                             订单商户编号
    private long                                   outId;//         是                             外部系统单号
    private long                              designType;//         是                             产品类型，由设计平台提供，业务方适配。
    private long                              industryId;//         是                             行业编号，由设计平台提供，业务方适配。
    private int                                draftType;//         是                             稿件类型，0:自来稿，1:改稿自来稿，2:普通设计,3:高级设计
    private int                               designPage;//         是                             设计面数，单面为1，双面为2
    private int                                  printKs;//         是                             设计款数
    private int                                  printMs;//         是                             设计模数
    private double                           designWidth;//         是                             设计宽度，单位mm，最多两位小数，含出血
    private double                          designHeight;//         是                             设计高度，单位mm，最多两位小数，含出血
    private double                            printWidth;//         否                             特殊尺寸宽度，单位mm，最多两位小数, 不含出血(用户尺寸)
    private double                           printHeight;//         否                             特殊尺寸高度，单位mm，最多两位小数, 不含出血(用户尺寸)
    private double                                amount;//         否                             金额最多支持两位小数
    private boolean                             isUrgent;//         是                             是否加急，。
    private String                           userContact;//          否              100            联系人 
    private String                            userMobile;//          是              64             联系电话
    private String                             buyerNick;//          否              100            买家昵称
    private String                                userQq;//          否              64             买家联系QQ
    private String                                userWx;//          否              64             买家联系微信号
    private String                             orderText;//          否              200            产品全称，最多200个字符
    private String                            afterNames;//          否              500            后加工 多个逗号隔开
    private String                          printSpecial;//          否              100            特殊工艺，最多100个字符
    private String                              userText;//          否              4000           客户文本，最多4000个字符
    private String                            userNotice;//          否              1000           设计注意事项，最多1000个字符
    private String                              shopNick;//          否              32             店铺名 最多32字符
    private String                       servicesMessage;//          否              500            店铺名 最多500字符
    private List<YangcaiApiFile>                apiFiles;//          否              0              用户文件资料

    public String getMethod()
    {
        return ORDER_CREATE;
    }

    public DesignOrderCreateResponse newResponse()
    {
        return new DesignOrderCreateResponse();
    }

    protected void buildQueryBody()
    {
        addParam("merchantId", merchantId);
        addParam("outId", outId);
        addParam("designType", designType);
        addParam("industryId", industryId);
        addParam("draftType", draftType);
        addParam("designPage", designPage);
        addParam("printKs", printKs);
        addParam("printMs", printMs);
        addParam("designWidth", designWidth);
        addParam("designHeight", designHeight);
        addParam("printWidth", printWidth);
        addParam("printHeight", printHeight);
        addParam("amount", amount);
        addParam("isUrgent", isUrgent);
        addParam("userContact", userContact);
        addParam("userMobile", userMobile);
        addParam("buyerNick", buyerNick);
        addParam("userQq", userQq);
        addParam("userWx", userWx);
        addParam("orderText", orderText);
        addParam("afterNames", afterNames);
        addParam("printSpecial", printSpecial);
        addParam("userText", userText);
        addParam("userNotice", userNotice);
        addParam("shopNick", shopNick);
        addParam("servicesMessage", servicesMessage);
        addParam("apiFiles", Jsons.toString(apiFiles));
    }

    public long getMerchantId()
    {
        return merchantId;
    }

    public void setMerchantId(long merchantId)
    {
        this.merchantId = merchantId;
    }

    public long getOutId()
    {
        return outId;
    }

    public void setOutId(long outId)
    {
        this.outId = outId;
    }

    public long getDesignType()
    {
        return designType;
    }

    public void setDesignType(long designType)
    {
        this.designType = designType;
    }

    public long getIndustryId()
    {
        return industryId;
    }

    public void setIndustryId(long industryId)
    {
        this.industryId = industryId;
    }

    public int getDraftType()
    {
        return draftType;
    }

    public void setDraftType(int draftType)
    {
        this.draftType = draftType;
    }

    public int getDesignPage()
    {
        return designPage;
    }

    public void setDesignPage(int designPage)
    {
        this.designPage = designPage;
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

    public String getShopNick()
    {
        return shopNick;
    }

    public void setShopNick(String shopNick)
    {
        this.shopNick = shopNick;
    }

    public String getServicesMessage()
    {
        return servicesMessage;
    }

    public void setServicesMessage(String servicesMessage)
    {
        this.servicesMessage = servicesMessage;
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
