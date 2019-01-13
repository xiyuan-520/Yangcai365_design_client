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

import java.util.ArrayList;
import java.util.List;

import org.zhiqim.kernel.json.Jsons;

import com.yangcai.design.client.YangcaiApiFile;
import com.yangcai.design.client.YangcaiClientResponse;

/****
 * 订单创建响应
 *
 * @version v1.0.0 @author lgz 2019-1-12 新建与整理
 */
public class DesignOrderCreateResponse extends YangcaiClientResponse
{
    private List<DesignOrder> orderList;
    protected void buildResponse(String json)
    {
        List<DesignOrder> list = new ArrayList<DesignOrder>();;
        List<String> orderJsons = Jsons.toList(Jsons.getString(json, "orderList"), String.class);
        for (String orderJson : orderJsons)
        {
            DesignOrder order = Jsons.toObject(orderJson, DesignOrder.class);
            List<YangcaiApiFile> apiFiles = Jsons.toList(Jsons.getString(orderJson, "apiFiles"), YangcaiApiFile.class);
            apiFiles = apiFiles != null ? apiFiles : new ArrayList<YangcaiApiFile>();
            
            if (order != null)
                order.setApiFiles(apiFiles);
            
            list.add(order);
        }
        
        
        setOrderList(list);
    }
    public List<DesignOrder> getOrderList()
    {
        return orderList;
    }
    public void setOrderList(List<DesignOrder> orderList)
    {
        this.orderList = orderList;
    }
    
    public String toString()
    {
        return Jsons.toString(this);
    }
}
