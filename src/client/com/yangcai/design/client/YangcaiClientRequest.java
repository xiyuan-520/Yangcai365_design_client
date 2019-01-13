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

import java.util.Map;
import java.util.TreeMap;

import org.zhiqim.kernel.json.Jsons;
import org.zhiqim.kernel.util.DateTimes;
import org.zhiqim.kernel.util.Strings;
import org.zhiqim.kernel.util.Urls;
import org.zhiqim.kernel.util.Validates;
import org.zhiqim.kernel.util.codes.MD5;

public abstract class YangcaiClientRequest<T extends YangcaiClientResponse> implements YangcaiApi
{
    private String method;
    private String timestamp;
    private String sign;

    private TreeMap<String, String> paramMap = new TreeMap<String, String>();
    public YangcaiClientRequest()
    {
        this.method = getMethod();
        this.timestamp = DateTimes.getDateTimeString();
    }
 
    /********************************************************/
    // 以下为子类必须实现方法
    /********************************************************/

    /**
     * 子类必须实现方法获取
     * 
     * @return 方法名称
     */
    public abstract String getMethod();

    /**
     * 子类必须实现响应对象的初始化
     * 
     * @return 响应对象
     */
    public abstract T newResponse();

    /**
     * 子类必须实现属性设置到MAP中，图片除外
     */
    protected abstract void buildQueryBody();
    
    
    /********************************************************/
    // 以下为父类提供的子类调用方法
    /********************************************************/

    /** 增加INT参数 */
    protected void addParam(String key, int value)
    {
        if (value == -1)
            return;

        paramMap.put(key, "" + value);
    }

    /** 增加LONG参数 */
    protected void addParam(String key, long value)
    {
        if (value == -1)
            return;

        paramMap.put(key, "" + value);
    }

    /** 增加String参数 */
    protected void addParam(String key, String value)
    {
        if (Validates.isEmptyBlank(value))
            return;

        paramMap.put(key, Strings.trim(value));
    }

    /** 增加boolean参数 */
    protected void addParam(String key, boolean value)
    {
        paramMap.put(key, "" + value);
    }

    /** 增加Object参数 */
    protected void addParam(String key, Object value)
    {
        if (Validates.isEmpty(value))
            return;

        paramMap.put(key, Jsons.toString(value));
    }
    
    
    /**
     * 生成签名,本方法需子类实现buildSignBody
     * 
     * @param appSecret 传入密钥
     */
    public void buildSign(String appKey, String appSecret)
    {
        // 系统参数
        addParam("method", method);
        addParam("timestamp", timestamp);
        addParam("appKey", appKey);

        StringBuffer strb = new StringBuffer();
        strb.append(appSecret).append(method).append(timestamp).append(appKey).append(appSecret);
        this.sign = MD5.encodeUTF8(strb.toString());
    }

    /**
     * 生成请求QueryString，该方法必须在buildSign之后执行
     * http://order.redxyz.net/rest.htm?sign=
     * 2B4B434E207025583B069F0D0A5EE91E&timestamp
     * =2011-07-01+13%3A52%3A03&v=2.0&nick=test&method=order.tid.get
     * @return 返回如foo=1&abc=2之类的字符串
     */
    public String buildQueryString()
    {
        buildQueryBody();
        StringBuffer strb = new StringBuffer("sign=").append(sign);
        for (Map.Entry<String, String> entry : paramMap.entrySet())
        {
            String value = Urls.encodeUTF8(entry.getValue());
            strb.append("&").append(entry.getKey()).append("=").append(value);
        }

        return strb.toString();
    }

    public String toString()
    {
        return buildQueryString();
    }
}
