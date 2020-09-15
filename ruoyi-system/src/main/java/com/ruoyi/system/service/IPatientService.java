package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Patient;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2020-09-15
 */
public interface IPatientService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param patientId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Patient selectPatientById(Long patientId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param patient 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Patient> selectPatientList(Patient patient);

    /**
     * 新增【请填写功能名称】
     *
     * @param patient 【请填写功能名称】
     * @return 结果
     */
    public int insertPatient(Patient patient);

    /**
     * 修改【请填写功能名称】
     *
     * @param patient 【请填写功能名称】
     * @return 结果
     */
    public int updatePatient(Patient patient);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePatientByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param patientId 【请填写功能名称】ID
     * @return 结果
     */
    public int deletePatientById(Long patientId);

    public String checkIdNumberUnique(String idNumber);

    public String checkPatientIdUnique(Long patientId);

    public String checkPhonenumberUnique(Patient patient);
}
