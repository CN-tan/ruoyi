package com.ruoyi.system.service;

import com.ruoyi.system.domain.PatientOrder;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
public interface IPatientOrderService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param orderId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public PatientOrder selectPatientOrderById(Long orderId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param patientOrder 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<PatientOrder> selectPatientOrderList(PatientOrder patientOrder);

    /**
     * 新增【请填写功能名称】
     * 
     * @param patientOrder 【请填写功能名称】
     * @return 结果
     */
    public int insertPatientOrder(PatientOrder patientOrder);

    /**
     * 修改【请填写功能名称】
     * 
     * @param patientOrder 【请填写功能名称】
     * @return 结果
     */
    public int updatePatientOrder(PatientOrder patientOrder);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePatientOrderByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param orderId 【请填写功能名称】ID
     * @return 结果
     */
    public int deletePatientOrderById(Long orderId);
}
