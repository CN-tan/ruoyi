package com.ruoyi.system.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.Doctor;
import com.ruoyi.system.domain.DoctorWithDepartment;
import com.ruoyi.system.mapper.DoctorMapper;
import com.ruoyi.system.service.IDoctorService;
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
public class DoctorServiceImpl implements IDoctorService 
{
    @Autowired
    private DoctorMapper doctorMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param doctorId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public DoctorWithDepartment selectDoctorById(Long doctorId)
    {
        return doctorMapper.selectDoctorById(doctorId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param doctor 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<DoctorWithDepartment> selectDoctorList(DoctorWithDepartment doctor)
    {
        return doctorMapper.selectDoctorList(doctor);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param doctor 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDoctor(Doctor doctor)
    {
        return doctorMapper.insertDoctor(doctor);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param doctor 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDoctor(Doctor doctor)
    {
        return doctorMapper.updateDoctor(doctor);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDoctorByIds(String ids)
    {
        return doctorMapper.deleteDoctorByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param doctorId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteDoctorById(Long doctorId)
    {
        return doctorMapper.deleteDoctorById(doctorId);
    }

    @Override
    public String checkDoctorIdUnique(Long doctorId) {
        int count= doctorMapper.checkDoctorIdUnique(doctorId);
        if (count > 0)
        {
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }
}
