package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.constant.UserConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PatientOrderMapper;
import com.ruoyi.system.domain.PatientOrder;
import com.ruoyi.system.service.IPatientOrderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 挂号Service业务层处理
 *
 * @author tanchong
 * @date 2020-09-15
 */
@Service
public class PatientOrderServiceImpl implements IPatientOrderService
{
    @Autowired
    private PatientOrderMapper patientOrderMapper;

    /**
     * 查询挂号
     *
     * @param orderId 挂号ID
     * @return 挂号
     */
    @Override
    public PatientOrder selectPatientOrderById(Long orderId)
    {
        return patientOrderMapper.selectPatientOrderById(orderId);
    }

    /**
     * 查询挂号列表
     *
     * @param patientOrder 挂号
     * @return 挂号
     */
    @Override
    public List<PatientOrder> selectPatientOrderList(PatientOrder patientOrder)
    {
        return patientOrderMapper.selectPatientOrderList(patientOrder);
    }

    /**
     * 新增挂号
     *
     * @param patientOrder 挂号
     * @return 结果
     */
    @Override
    public int insertPatientOrder(PatientOrder patientOrder)
    {
        return patientOrderMapper.insertPatientOrder(patientOrder);
    }

    /**
     * 修改挂号
     *
     * @param patientOrder 挂号
     * @return 结果
     */
    @Override
    public int updatePatientOrder(PatientOrder patientOrder)
    {
        return patientOrderMapper.updatePatientOrder(patientOrder);
    }

    /**
     * 删除挂号对象
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
     * 删除挂号信息
     *
     * @param orderId 挂号ID
     * @return 结果
     */
    @Override
    public int deletePatientOrderById(Long orderId)
    {
        return patientOrderMapper.deletePatientOrderById(orderId);
    }

    @Override
    public String checkDoctorIdExists(Long doctorId) {
        int count=patientOrderMapper.checkDoctorIdExists(doctorId);
        if(count > 0) {
            return UserConstants.EXISTS;
        }
        return UserConstants.NOT_EXISTS;
    }

    @Override
    public String checkPatientIdExists(Long patientId) {
        int count=patientOrderMapper.checkPatientIdExists(patientId);
        if(count > 0) {
            return UserConstants.EXISTS;
        }
        return UserConstants.NOT_EXISTS;
    }
}