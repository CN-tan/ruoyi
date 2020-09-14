package com.ruoyi.system.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.Hospital;
import com.ruoyi.system.mapper.HospitalMapper;
import com.ruoyi.system.service.IHospitalService;
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
public class HospitalServiceImpl implements IHospitalService 
{
    @Autowired
    private HospitalMapper hospitalMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param hospitalId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Hospital selectHospitalById(Long hospitalId)
    {
        return hospitalMapper.selectHospitalById(hospitalId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param hospital 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Hospital> selectHospitalList(Hospital hospital)
    {
        return hospitalMapper.selectHospitalList(hospital);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param hospital 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertHospital(Hospital hospital)
    {
        return hospitalMapper.insertHospital(hospital);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param hospital 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateHospital(Hospital hospital)
    {
        return hospitalMapper.updateHospital(hospital);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHospitalByIds(String ids)
    {
        return hospitalMapper.deleteHospitalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param hospitalId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteHospitalById(Long hospitalId)
    {
        return hospitalMapper.deleteHospitalById(hospitalId);
    }

    @Override
    public String checkHospitalIdUnique(Long hospitalId){
        int count=hospitalMapper.checkHospitalIdUnique(hospitalId);
        if(count > 0){
            return UserConstants.DICT_TYPE_NOT_UNIQUE;
        }
        return UserConstants.DICT_TYPE_UNIQUE;
    }

    @Override
    public String checkHospitalNameUnique(String hospitalName){
        int count =hospitalMapper.checkHospitalNameUnique(hospitalName);
        if(count > 0){
            return UserConstants.DICT_TYPE_NOT_UNIQUE;
        }
        return UserConstants.DICT_TYPE_UNIQUE;
    }
    
    @Override
    public String checkPhonenumberUnique(Hospital hospital){
        Long hospitalId = StringUtils.isNull(hospital.getHospitalId()) ? -1L : hospital.getHospitalId();
        Hospital info = hospitalMapper.checkPhonenumberUnique(hospital.getPhonenumber());
        if (StringUtils.isNotNull(info) && info.getHospitalId().longValue() != hospitalId.longValue())
        {
            return UserConstants.USER_PHONE_NOT_UNIQUE;
        }
        return UserConstants.USER_PHONE_UNIQUE;
    }
}
