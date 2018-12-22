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

import org.zhiqim.kernel.util.Validates;

/***
 * 下单发货平台 接口参数
 *
 * @version v1.0.0 @author Administrator 2018-12-2 新建与整理
 */
public class YangcaiClientParam
{
    private String restUrl = null; // 应用API调用地址

    private String merchantId; // API调用用户昵称 或者 商户编号
    private String appSecret; // API调用用户密钥

    private int connectTimeout = 10; // API调用时允许的连接超时时长
    private int readTimeout = 3*60; // API调用时允许的连接读取时长 默认3分钟
    
    /** 简单判断是否传入了KEY和密钥 */
    public boolean isValid()
    {
        if (Validates.isEmptyBlank(restUrl) || Validates.isEmptyBlank(appSecret))
            return false;

        return true;
    }

    /*****************************************/
    // 设置&获取属性
    /*****************************************/
    public String getRestUrl()
    {
        return restUrl;
    }

    public void setRestUrl(String restUrl)
    {
        this.restUrl = restUrl;
    }

    public String getMerchantId()
    {
        return merchantId;
    }

    public void setMerchantId(String merchantId)
    {
        this.merchantId = merchantId;
    }

    public String getAppSecret()
    {
        return appSecret;
    }

    public void setAppSecret(String appSecret)
    {
        this.appSecret = appSecret;
    }

    public int getConnectTimeout()
    {
        return connectTimeout;
    }
   
    public void setConnectTimeout(int connectTimeout)
    {
        if (connectTimeout < 10 || connectTimeout > 60)
            return;

        this.connectTimeout = connectTimeout;
    }
    
    public int getReadTimeout()
    {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout)
    {
        if (readTimeout < 10 || readTimeout > 30*60)
            return;

        this.readTimeout = readTimeout;
    }
}
