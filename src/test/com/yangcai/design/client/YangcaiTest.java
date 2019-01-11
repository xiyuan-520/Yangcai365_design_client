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

import org.zhiqim.kernel.constants.SignConstants;
import org.zhiqim.kernel.util.DateTimes;

import com.yangcai.design.client.after.DesignAfterCreateResponse;
import com.yangcai.design.client.order.DesignOrder;
import com.yangcai.design.client.order.DesignOrderSynRequest;
import com.yangcai.design.client.order.DesignOrderSynResponse;
import com.yangcai.design.client.order.update.DesignOrderUpdateSpecificationRequest;
import com.yangcai.design.client.order.update.DesignOrderUpdateSpecificationResponse;

public class YangcaiTest implements SignConstants
{
    @SuppressWarnings("unused")
    public static void main(String[] args)
    {
        int connectTimeout = 10;
        int readTimeout = 10*60;
        String restUrl = "http://127.0.0.1:8081/designRest.htm";
//        String restUrl = "http://server.yangcai365.com/designRest.htm";
        long merchantId = 1823193185001L;
        String appKey = ""+merchantId;
        String appSecret = "32B1CCF38368E42AD31413B90309F69A";
        
//        String startModifyTime ="2018-12-24";
//        String endModifyTime = DateTimes.getDateTimeString();
        String startModifyTime = DateTimes.getPreviousDateTimeStringBySecond(30*60);
        String endModifyTime = DateTimes.getDateTimeString();
        
        YangcaiClientParam param = new YangcaiClientParam();
        param.setConnectTimeout(connectTimeout);
        param.setReadTimeout(readTimeout);
        param.setRestUrl(restUrl);
        param.setAppKey(appKey);
        param.setAppSecret(appSecret);
        
        DesignOrderSynRequest synReq = new DesignOrderSynRequest();
        synReq.setMerchantId(merchantId);
        synReq.setStartModifyTime(startModifyTime);
        synReq.setEndModifyTime(endModifyTime);
        
        System.out.println("startModifyTime = " + startModifyTime);
        System.out.println("endModifyTime   = " + endModifyTime);
//        
       
//        
//        DesignOrderSynResponse synResp = YangcaiClient.execute(synReq, param);
//        System.out.println(synResp.getResponseText());
//        for (DesignOrder order : synResp.getOrderList())
//        {
//            System.out.println(order);
//        }
//        System.out.println(synResp.getOrderList().size());
//        
//        62x56,89x87
//        [{"printMs":1,"printWidth":424.0,"printHeight":289.0}, {"printMs":1,"printWidth":424.0,"printHeight":289.0}]
         //订单规格修改
        DesignOrderUpdateSpecificationRequest specReq = new DesignOrderUpdateSpecificationRequest();
        specReq.setAfterNames("");
        specReq.setAmount(20.66);
        specReq.setBuyerNick("测试修改BuyerNick");
        specReq.setDesignHeight(120.66);
        specReq.setDesignId(1900458550032L);
        specReq.setDesignPage(4);
        specReq.setDesignWidth(121.02);
        specReq.setDraftType(2);
        specReq.setIndustryId(6926);
        specReq.setMerchantId(merchantId);
        specReq.setOrderText("修改的订单信息");
        specReq.setPrintHeight(66);
        specReq.setPrintKs(5);
        specReq.setPrintMs(6);
        specReq.setPrintSpecial("修改的特殊工艺");
        specReq.setPrintWidth(67);
        specReq.setServicesMessage("测试的客服留言");
        specReq.setUrgent(true);
        specReq.setUserContact("修改的联系人");
        specReq.setUserMobile("修改的联系手机");
        specReq.setUserQq("修改的qq");
        specReq.setUserWx("修改的wx");
        DesignOrderUpdateSpecificationResponse specResp = YangcaiClient.execute(specReq, param);
        System.out.println(specResp.getResponseText());
        
//        //售后创建接口
//        long designId = 1805121158191104L;
//        DesignAfterCreateRequest afscreq = new DesignAfterCreateRequest();
//        afscreq.setDesignId(designId);
//        afscreq.setMerchantId(merchantId);
//        afscreq.setOutAfsId(""+designId);
//        afscreq.setProblemDesc("设计有问题");
//        
//        List<YangcaiApiFile> afsFiles = new ArrayList<YangcaiApiFile>();
//        YangcaiApiFile afsFile = new YangcaiApiFile();
//        afsFile.setFileName(designId+"-售后文件.pdf");
//        afsFile.setFileExt("pdf");
//        afsFile.setDownUrl("http://yangcai-taobao.oss-cn-shenzhen.aliyuncs.com/20181221/EndFile/1812211907566166.pdf");
//        afsFiles.add(afsFile);
//        afsFile.setFileSize(20000);
//        afscreq.setApiFiles(afsFiles);
//       DesignAfterCreateResponse afscresp = YangcaiClient.execute(afscreq, param);
//       System.out.println(afscresp.getResponseText());
//       System.out.println(afscresp.getDesignAfsId());
//        
        //售后创建接口
//      DesignAfterSynRequest afssynreq = new DesignAfterSynRequest();
//      afssynreq.setMerchantId(merchantId);
//      afssynreq.setStartModifyTime("2018-12-29 00:00:00");
//      afssynreq.setEndModifyTime(DateTimes.getDateTimeString());
//    
//      DesignAfterSynResponse afssynresp = YangcaiClient.execute(afssynreq, param);
//      System.out.println(afssynresp.getAfterList());
//      DesignAfterCancelRequest afsCancelreq = new DesignAfterCancelRequest();
//      afsCancelreq.setMerchantId(merchantId);
//      afsCancelreq.setDesignAfsId(1812271201450002L);
//      afsCancelreq.setCancelNote("csdcsdcdscdcdsc");
//    
//      DesignAfterCancelResponse afscancelresp = YangcaiClient.execute(afsCancelreq, param);
//      System.out.println(afscancelresp.getResponseText());
        
//        String sss = "3.65GiB";
//        System.out.println((long)Math.ceil(1*GiB));
//        int l = 13;
//        byte[] t = new byte[l];
//        for (int i = 0; i< l; i++)
//            t[i] = 55;
//        
//        byte[] b= Base64Decoder.decode(t);
////        Base64Encoder.encode(src)
//        System.out.println(b);
//        
//        Object dss= 1;
//        System.out.println(dss.toString());
    }
}



















