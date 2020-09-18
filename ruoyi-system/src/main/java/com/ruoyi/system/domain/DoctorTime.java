package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 排班对象 doctor_time
 * 
 * @author tanchong
 * @date 2020-09-17
 */
public class DoctorTime extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    private int kind;


    private String date;
    /** 医生编号 */
    @Excel(name = "医生编号")
    private Long doctorId;

    /** 时间段 */
    @Excel(name = "时间段")
    private String time;

    /** 已接诊数 */
    @Excel(name = "已接诊数")
    private Long num;

    /** 可否挂号 */
    @Excel(name = "可否挂号")
    private String status;

    /** 接诊日期 */
    @Excel(name = "接诊日期")
    private String data;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDoctorId(Long doctorId) 
    {
        this.doctorId = doctorId;
    }

    public Long getDoctorId() 
    {
        return doctorId;
    }
    public void setTime(String time) 
    {
        this.time = time;
    }

    public String getTime() 
    {
        return time;
    }
    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setData(String data) 
    {
        this.data = data;
    }

    public String getData() 
    {
        return data;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("doctorId", getDoctorId())
            .append("time", getTime())
            .append("num", getNum())
            .append("status", getStatus())
            .append("data", getData())
            .toString();
    }
}
