package com.ruoyi.system.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.Patient;
import com.ruoyi.system.mapper.PatientMapper;
import com.ruoyi.system.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
@Service
public class PatientServiceImpl implements IPatientService 
{
    @Autowired
    private PatientMapper patientMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param idNumber 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Patient selectPatientById(String idNumber)
    {
        return patientMapper.selectPatientById(idNumber);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param patient 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Patient> selectPatientList(Patient patient)
    {
        return patientMapper.selectPatientList(patient);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param patient 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertPatient(Patient patient)
    {
        return patientMapper.insertPatient(patient);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param patient 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updatePatient(Patient patient)
    {
        return patientMapper.updatePatient(patient);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePatientByIds(String ids)
    {
        return patientMapper.deletePatientByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param idNumber 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deletePatientById(String idNumber)
    {
        return patientMapper.deletePatientById(idNumber);
    }

    @Override
    public String checkPatientIdUnique(Long patientId) {
        int count= patientMapper.checkPatientIdUnique(patientId);
        if (count > 0)
        {
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }
}
