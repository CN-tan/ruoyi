package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Doctor;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
public interface DoctorMapper 
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
    public List<Doctor> selectDoctorList(Doctor doctor);

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
     * 删除【请填写功能名称】
     * 
     * @param doctorId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteDoctorById(Long doctorId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param doctorIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteDoctorByIds(String[] doctorIds);

    public int checkDoctorIdUnique(Long doctorId);

}
