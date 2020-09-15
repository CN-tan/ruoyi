package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 【请填写功能名称】对象 patient_order
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
public class PatientOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long orderId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long doctorId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long patientId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long startTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long endTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long orderFee;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer hasPay;

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
    public void setStartTime(Long startTime)
    {
        this.startTime = startTime;
    }

    public Long getStartTime()
    {
        return startTime;
    }
    public void setEndTime(Long endTime)
    {
        this.endTime = endTime;
    }

    public Long getEndTime()
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
    public void setHasPay(Integer hasPay) 
    {
        this.hasPay = hasPay;
    }

    public Integer getHasPay() 
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
