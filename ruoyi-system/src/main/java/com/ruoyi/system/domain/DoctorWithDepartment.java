package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DoctorWithDepartment {
    private String hospitalName;
    private String department;

    public DoctorWithDepartment() {
    }
    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDepartment() {
        return department;
    }

    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long doctorId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String doctorName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String nameLevel;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long orderCount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long satisRate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long orderFee;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String introduction;

    public void setDoctorId(Long doctorId)
    {
        this.doctorId = doctorId;
    }

    public Long getDoctorId()
    {
        return doctorId;
    }
    public void setDoctorName(String doctorName)
    {
        this.doctorName = doctorName;
    }

    public String getDoctorName()
    {
        return doctorName;
    }
    public void setnameLevel(String nameLevel)
    {
        this.nameLevel = nameLevel;
    }

    public String getnameLevel()
    {
        return nameLevel;
    }
    public void setOrderCount(Long orderCount)
    {
        this.orderCount = orderCount;
    }

    public Long getOrderCount()
    {
        return orderCount;
    }
    public void setSatisRate(Long satisRate)
    {
        this.satisRate = satisRate;
    }

    public Long getSatisRate()
    {
        return satisRate;
    }
    public void setOrderFee(Long orderFee)
    {
        this.orderFee = orderFee;
    }

    public Long getOrderFee()
    {
        return orderFee;
    }
    public void setIntroduction(String introduction)
    {
        this.introduction = introduction;
    }

    public String getIntroduction()
    {
        return introduction;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    @Override
    public String toString(){
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("doctorId", getDoctorId())
                .append("doctorName", getDoctorName())
                .append("hospitalName",getHospitalName())
                .append("department",getDepartment())
                .append("nameLevel", getnameLevel())
                .append("orderCount", getOrderCount())
                .append("satisRate", getSatisRate())
                .append("orderFee", getOrderFee())
                .append("introduction", getIntroduction())
                .toString();
    }
}

