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
import org.zhiqim.kernel.util.DateTimes;
import org.zhiqim.kernel.util.Sqls;
import org.zhiqim.kernel.util.Strings;

import com.yangcai.design.client.after.DesignAfterCreateRequest;
import com.yangcai.design.client.after.DesignAfterSynResponse;
import com.yangcai.design.client.order.DesignOrder;
import com.yangcai.design.client.order.DesignOrderSynRequest;
import com.yangcai.design.client.order.DesignOrderSynResponse;

public class YangcaiTest
{
    @SuppressWarnings("unused")
    public static void main(String[] args)
    {
        int connectTimeout = 10;
        int readTimeout = 10*60;
        String restUrl = "http://127.0.0.1:8081/designRest.htm";
        long merchantId = 1823193185001L;
        String appSecret = "32B1CCF38368E42AD31413B90309F69A";
        
        String startModifyTime = DateTimes.getPreviousDateTimeStringBySecond(30*60);
        String endModifyTime = DateTimes.getDateTimeString();
        
        YangcaiClientParam param = new YangcaiClientParam();
        param.setConnectTimeout(connectTimeout);
        param.setReadTimeout(readTimeout);
        param.setRestUrl(restUrl);
        param.setMerchantId(Strings.valueOf(merchantId));
        param.setAppSecret(appSecret);
//        
//        DesignOrderSynRequest synReq = new DesignOrderSynRequest();
//        synReq.setMerchantId(merchantId);
//        synReq.setStartModifyTime(startModifyTime);
//        synReq.setEndModifyTime(endModifyTime);
//        
//        System.out.println("startModifyTime = " + startModifyTime);
//        System.out.println("endModifyTime   = " + endModifyTime);
//        
       
//        
//        DesignOrderSynResponse synResp = YangcaiClient.execute(synReq, param);
//        for (DesignOrder order : synResp.getOrderList())
//        {
//            System.out.println(order);
//        }
//        System.out.println(synResp.getOrderList().size());
        
        
        //售后创建接口
        DesignAfterCreateRequest afscreq = new DesignAfterCreateRequest();
        afscreq.setDesignId(1826144321001L);
        afscreq.setMerchantId(merchantId);
        afscreq.setOutAfsId("1826144321001");
        afscreq.setProblemDesc("设计有问题");
        
       DesignAfterSynResponse afsresp = YangcaiClient.execute(afscreq, param);
       System.out.println(afsresp.getResponseText());
    }
}



















