package com.ruoyi.system.service;

import com.ruoyi.system.domain.Hospital;

import javax.print.DocFlavor;
import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
public interface IHospitalService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param hospitalId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Hospital selectHospitalById(Long hospitalId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param hospital 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Hospital> selectHospitalList(Hospital hospital);

    /**
     * 新增【请填写功能名称】
     * 
     * @param hospital 【请填写功能名称】
     * @return 结果
     */
    public int insertHospital(Hospital hospital);

    /**
     * 修改【请填写功能名称】
     * 
     * @param hospital 【请填写功能名称】
     * @return 结果
     */
    public int updateHospital(Hospital hospital);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHospitalByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param hospitalId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteHospitalById(Long hospitalId);

    public String checkHospitalIdUnique(Long hospitalId);

    public String checkHospitalNameUnique(String hospitalName);

    public String checkPhonenumberUnique(Hospital hospital);
}
