package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Patient;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
public interface PatientMapper {
    /**
     * 查询【请填写功能名称】
     *
     * @param idNumber 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Patient selectPatientById(String idNumber);

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
     * 删除【请填写功能名称】
     *
     * @param idNumber 【请填写功能名称】ID
     * @return 结果
     */
    public int deletePatientById(String idNumber);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param idNumbers 需要删除的数据ID
     * @return 结果
     */
    public int deletePatientByIds(String[] idNumbers);


    public int checkIdNumberUnique(String idNumber);

    public int checkPatientIdUnique(Long patientId);

    public Patient checkPhonenumberUnique(String phonenumber);
}
