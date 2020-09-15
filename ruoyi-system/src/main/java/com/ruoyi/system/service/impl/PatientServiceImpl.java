package com.ruoyi.system.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.Patient;
import com.ruoyi.system.domain.SysUser;
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
     * @param patientId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Patient selectPatientById(Long patientId)
    {
        return patientMapper.selectPatientById(patientId);
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
     * @param patientId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deletePatientById(Long patientId)
    {
        return patientMapper.deletePatientById(patientId);
    }

    @Override
    public String checkIdNumberUnique(String idNumber) {
        int count= patientMapper.checkIdNumberUnique(idNumber);
        if (count > 0)
        {
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }
    @Override
    public String checkPatientIdUnique(Long patientId){
        int count= patientMapper.checkPatientIdUnique(patientId);
        if (count > 0)
        {
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }

    @Override
    public String checkPhonenumberUnique(Patient patient){
        Long patientId = StringUtils.isNull(patient.getPatientId()) ? -1L : patient.getPatientId();
        Patient info = patientMapper.checkPhonenumberUnique(patient.getPhonenumber());
        if (StringUtils.isNotNull(info) && info.getPatientId().longValue() != patientId.longValue())
        {
            return UserConstants.USER_PHONE_NOT_UNIQUE;
        }
        return UserConstants.USER_PHONE_UNIQUE;
    }
}
