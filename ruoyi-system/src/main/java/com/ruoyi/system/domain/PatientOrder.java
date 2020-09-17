package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 挂号对象 patient_order
 *
 * @author tanchong
 * @date 2020-09-15
 */
public class PatientOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private Long orderId;

    /** 医生编号 */
    @Excel(name = "医生编号")
    private Long doctorId;

    /** 病人编号 */
    @Excel(name = "病人编号")
    private Long patientId;

    /** 出诊时间 */
    @Excel(name = "出诊时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String startTime;

    /** 下订单时间，精确到年月日 */
    @Excel(name = "下订单时间，精确到年月日", width = 30, dateFormat = "yyyy-MM-dd")
    private String endTime;

    /** 挂号费 */
    @Excel(name = "挂号费")
    private Long orderFee;

    /** 是否支付 */
    @Excel(name = "订单状态")
    private String hasPay;

    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public Long getOrderId()
    {
        return orderId;
    }
    public void setDoctorId(Long doctorId)
    {
        this.doctorId = doctorId;
    }

    public Long getDoctorId()
    {
        return doctorId;
    }
    public void setPatientId(Long patientId)
    {
        this.patientId = patientId;
    }

    public Long getPatientId()
    {
        return patientId;
    }
    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getStartTime()
    {
        return startTime;
    }
    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    public String getEndTime()
    {
        return endTime;
    }
    public void setOrderFee(Long orderFee)
    {
        this.orderFee = orderFee;
    }

    public Long getOrderFee()
    {
        return orderFee;
    }
    public void setHasPay(String hasPay)
    {
        this.hasPay = hasPay;
    }
    public String getHasPay()
    {
        return hasPay;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("orderId", getOrderId())
                .append("doctorId", getDoctorId())
                .append("patientId", getPatientId())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("orderFee", getOrderFee())
                .append("hasPay", getHasPay())
                .toString();
    }
}