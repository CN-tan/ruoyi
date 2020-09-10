package com.ruoyi.system.service;

import com.ruoyi.system.domain.Doctor;
import com.ruoyi.system.domain.DoctorWithDepartment;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
public interface IDoctorService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param doctorId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Doctor selectDoctorById(Long doctorId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param doctor 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<DoctorWithDepartment> selectDoctorList(DoctorWithDepartment doctor);

    /**
     * 新增【请填写功能名称】
     * 
     * @param doctor 【请填写功能名称】
     * @return 结果
     */
    public int insertDoctor(Doctor doctor);

    /**
     * 修改【请填写功能名称】
     * 
     * @param doctor 【请填写功能名称】
     * @return 结果
     */
    public int updateDoctor(Doctor doctor);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDoctorByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param doctorId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteDoctorById(Long doctorId);

    public String checkDoctorIdUnique(Long doctorId);
}
