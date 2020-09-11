package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 patient
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
public class Patient extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long patientId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String patientName;

    /** $column.columnComment */
    private String idNumber;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String caseHistory;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String wechatState;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String alipayState;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String phonenumber;

    public void setPatientId(Long patientId) 
    {
        this.patientId = patientId;
    }

    public Long getPatientId() 
    {
        return patientId;
    }
    public void setPatientName(String patientName) 
    {
        this.patientName = patientName;
    }

    public String getPatientName() 
    {
        return patientName;
    }
    public void setIdNumber(String idNumber) 
    {
        this.idNumber = idNumber;
    }

    public String getIdNumber() 
    {
        return idNumber;
    }
    public void setCaseHistory(String caseHistory) 
    {
        this.caseHistory = caseHistory;
    }

    public String getCaseHistory() 
    {
        return caseHistory;
    }
    public void setWechatState(String wechatState) 
    {
        this.wechatState = wechatState;
    }

    public String getWechatState() 
    {
        return wechatState;
    }
    public void setAlipayState(String alipayState) 
    {
        this.alipayState = alipayState;
    }

    public String getAlipayState() 
    {
        return alipayState;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("patientId", getPatientId())
            .append("patientName", getPatientName())
            .append("idNumber", getIdNumber())
            .append("caseHistory", getCaseHistory())
            .append("wechatState", getWechatState())
            .append("alipayState", getAlipayState())
            .append("phonenumber", getPhonenumber())
            .toString();
    }
}
