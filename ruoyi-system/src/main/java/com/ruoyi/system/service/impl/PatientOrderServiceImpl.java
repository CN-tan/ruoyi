package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.PatientOrder;
import com.ruoyi.system.mapper.PatientOrderMapper;
import com.ruoyi.system.service.IPatientOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Service
public class PatientOrderServiceImpl implements IPatientOrderService 
{
    @Autowired
    private PatientOrderMapper patientOrderMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param orderId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public PatientOrder selectPatientOrderById(Long orderId)
    {
        return patientOrderMapper.selectPatientOrderById(orderId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param patientOrder 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<PatientOrder> selectPatientOrderList(PatientOrder patientOrder)
    {
        return patientOrderMapper.selectPatientOrderList(patientOrder);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param patientOrder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertPatientOrder(PatientOrder patientOrder)
    {
        return patientOrderMapper.insertPatientOrder(patientOrder);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param patientOrder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updatePatientOrder(PatientOrder patientOrder)
    {
        return patientOrderMapper.updatePatientOrder(patientOrder);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePatientOrderByIds(String ids)
    {
        return patientOrderMapper.deletePatientOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param orderId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deletePatientOrderById(Long orderId)
    {
        return patientOrderMapper.deletePatientOrderById(orderId);
    }
}
