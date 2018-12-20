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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.zhiqim.kernel.json.Jsons;

import com.yangcai.design.client.YangcaiApiFile;

/****
 * 订单相应对象
 *
 * @version v1.0.0 @author lgz 2018-12-18 新建与整理
 */
public class DesignOrder
{
    private long merchantId;    //2.订单商户编号
    private long designId;    //1.设订单编号，设计平台独立编号
    private int status;    //4.订单状态
    private String designer;    //32.设计师
    private Timestamp designReceiveTime;    //33.设计师领单时间
    private Timestamp designBeginTime;    //34.设计师开始设计时间
    private Timestamp designDraftTime;    //35.设计师初稿时间
    private Timestamp designEndTime;    //36.设计师定稿时间
    private String designPauseReason;    //37.设计师暂停原因（新增字段）
    private Timestamp designPauseTime;    //38.设计师暂停时间
    private String designExclude;    //39.设计师排除，多个逗号分隔
    private String designRequestReason;    //40.设计师请求主管支援原由
    private Timestamp requestTime;    //41.设计师请求主管支援 时间
    private String designRejectReason;    //42.主管支援拒绝原因
    private int designKeepDuration;    //43.设计师保留时长，单位分钟
    private String requestRefoundAcceptReason;    //44.请求退款原因
    private String canceler;    //49.取消人
    private Timestamp cancelTime;    //50.取消时间
    private String cancelReason;    //51.取消原因
    private Timestamp modifyTime;    //53.修改时间
    private List<YangcaiApiFile> apiFiles = new ArrayList<YangcaiApiFile>();//相应的文件
    
    //***************************稳定后删除******************************
    private String  endFileUrl;//订单完成后 成品文件 下载路径
    private String  endFileExt;//订单完成后 成品扩展名
    private long   endFileLength;//订单完成后 文件大小
    
    private String  designFileUrl;//订单完成后 设计文件 下载路径
    private String  designFileExt;//订单完成后 设计成品扩展名
    private long   designFileLength;//订单完成后 设计文件大小
    
    
    //**********************************************************
    
    public String toString()
    {
        return Jsons.toString(this);
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


    public int getStatus()
    {
        return status;
    }


    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getDesigner()
    {
        return designer;
    }


    public void setDesigner(String designer)
    {
        this.designer = designer;
    }


    public Timestamp getDesignReceiveTime()
    {
        return designReceiveTime;
    }


    public void setDesignReceiveTime(Timestamp designReceiveTime)
    {
        this.designReceiveTime = designReceiveTime;
    }


    public Timestamp getDesignBeginTime()
    {
        return designBeginTime;
    }


    public void setDesignBeginTime(Timestamp designBeginTime)
    {
        this.designBeginTime = designBeginTime;
    }


    public Timestamp getDesignDraftTime()
    {
        return designDraftTime;
    }


    public void setDesignDraftTime(Timestamp designDraftTime)
    {
        this.designDraftTime = designDraftTime;
    }


    public Timestamp getDesignEndTime()
    {
        return designEndTime;
    }


    public void setDesignEndTime(Timestamp designEndTime)
    {
        this.designEndTime = designEndTime;
    }


    public String getDesignPauseReason()
    {
        return designPauseReason;
    }


    public void setDesignPauseReason(String designPauseReason)
    {
        this.designPauseReason = designPauseReason;
    }


    public Timestamp getDesignPauseTime()
    {
        return designPauseTime;
    }


    public void setDesignPauseTime(Timestamp designPauseTime)
    {
        this.designPauseTime = designPauseTime;
    }


    public String getDesignExclude()
    {
        return designExclude;
    }


    public void setDesignExclude(String designExclude)
    {
        this.designExclude = designExclude;
    }


    public String getDesignRequestReason()
    {
        return designRequestReason;
    }


    public void setDesignRequestReason(String designRequestReason)
    {
        this.designRequestReason = designRequestReason;
    }


    public Timestamp getRequestTime()
    {
        return requestTime;
    }


    public void setRequestTime(Timestamp requestTime)
    {
        this.requestTime = requestTime;
    }


    public String getDesignRejectReason()
    {
        return designRejectReason;
    }


    public void setDesignRejectReason(String designRejectReason)
    {
        this.designRejectReason = designRejectReason;
    }


    public int getDesignKeepDuration()
    {
        return designKeepDuration;
    }


    public void setDesignKeepDuration(int designKeepDuration)
    {
        this.designKeepDuration = designKeepDuration;
    }


    public String getRequestRefoundAcceptReason()
    {
        return requestRefoundAcceptReason;
    }


    public void setRequestRefoundAcceptReason(String requestRefoundAcceptReason)
    {
        this.requestRefoundAcceptReason = requestRefoundAcceptReason;
    }


    public String getCanceler()
    {
        return canceler;
    }


    public void setCanceler(String canceler)
    {
        this.canceler = canceler;
    }


    public Timestamp getCancelTime()
    {
        return cancelTime;
    }


    public void setCancelTime(Timestamp cancelTime)
    {
        this.cancelTime = cancelTime;
    }


    public String getCancelReason()
    {
        return cancelReason;
    }


    public void setCancelReason(String cancelReason)
    {
        this.cancelReason = cancelReason;
    }


    public Timestamp getModifyTime()
    {
        return modifyTime;
    }


    public void setModifyTime(Timestamp modifyTime)
    {
        this.modifyTime = modifyTime;
    }

    public List<YangcaiApiFile> getApiFiles()
    {
        return apiFiles;
    }

    public void setApiFiles(List<YangcaiApiFile> apiFiles)
    {
        this.apiFiles = apiFiles;
    }

    public String getEndFileUrl()
    {
        return endFileUrl;
    }

    public void setEndFileUrl(String endFileUrl)
    {
        this.endFileUrl = endFileUrl;
    }

    public String getEndFileExt()
    {
        return endFileExt;
    }

    public void setEndFileExt(String endFileExt)
    {
        this.endFileExt = endFileExt;
    }

    public long getEndFileLength()
    {
        return endFileLength;
    }

    public void setEndFileLength(long endFileLength)
    {
        this.endFileLength = endFileLength;
    }

    public String getDesignFileUrl()
    {
        return designFileUrl;
    }

    public void setDesignFileUrl(String designFileUrl)
    {
        this.designFileUrl = designFileUrl;
    }

    public String getDesignFileExt()
    {
        return designFileExt;
    }

    public void setDesignFileExt(String designFileExt)
    {
        this.designFileExt = designFileExt;
    }

    public long getDesignFileLength()
    {
        return designFileLength;
    }

    public void setDesignFileLength(long designFileLength)
    {
        this.designFileLength = designFileLength;
    }
    
}
