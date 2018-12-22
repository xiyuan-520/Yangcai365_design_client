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

import org.zhiqim.kernel.json.Jsons;
import org.zhiqim.kernel.util.Validates;

/***
 * 相应基类
 * @version v1.0.0 @author longguizhi 2018-12-2 新建与整理
 */
public abstract class YangcaiClientResponse
{
    // 在基类加上统一的错误标识
    private YangcaiErrorResponse error;
    private String responseText;

    /**
     * 子类实现解析成功时的响应结果，默认失败时子类数据未初始化
     * 
     * @param json 由淘宝回传的字符串
     */
    protected abstract void buildResponse(String json);

    /**
     * 基类解析自定义错误，在发送淘宝前或发送到淘宝时失败，淘宝未正常响应
     * 
     * @param code 主错误码
     * @param msg 主错误描述
     * @param subCode 子错误码
     * @param subMsg 子错误描述
     * @param args 参数信息
     */
    public void buildResponseError(int code, String msg)
    {
        error = new YangcaiErrorResponse(code, msg);
    }

    /**
     * 基类解析响应结果，先判断是否是错误，是错误由基类处理完即结束，如果是成功再由子类解析
     * 
     * @param responseText 由淘宝回传的字符串
     */
    public void buildResponseText(String responseText)
    {
        this.responseText = responseText;

        if (responseText.startsWith("{error:"))
        {
            String errorMsg = Jsons.getObject(responseText, "error");
            error = Jsons.toObject(errorMsg, YangcaiErrorResponse.class);
        }
        else if (responseText.startsWith("<?xml"))
        {// XML
            if (Validates.isEmpty(responseText))
                return;

            buildResponse(responseText);
        }
        else
        {// JSON
         // String responseMsg = Jsons.getObject(responseText, "response");
            if (Validates.isEmpty(responseText))
                return;

            buildResponse(responseText);
        }
    }

    /** 是否成功 */
    public boolean isSuccess()
    {
        return error == null;
    }

    /** 主错误码 */
    public int getErrorCode()
    {
        if (error == null)
            return 0;
        else
            return error.getCode();
    }

    public String getErrorMsg()
    {
        if (error == null)
            return "";
        else
            return error.getMsg();
    }

    public YangcaiErrorResponse getError()
    {
        return error;
    }

    public String toString()
    {
        if (error != null)
            return error.toString();
        else
            return responseText;
    }
    
    public String getResponseText()
    {
        
        if (error != null)
            return error.toString();
        else
            return responseText;
    }
}

