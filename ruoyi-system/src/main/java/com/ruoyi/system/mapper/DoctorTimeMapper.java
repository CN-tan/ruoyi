package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.DoctorTime;

/**
 * 排班Mapper接口
 * 
 * @author tanchong
 * @date 2020-09-17
 */
public interface DoctorTimeMapper 
{
    /**
     * 查询排班
     * 
     * @param id 排班ID
     * @return 排班
     */
    public DoctorTime selectDoctorTimeById(Long id);

    /**
     * 查询排班列表
     * 
     * @param doctorTime 排班
     * @return 排班集合
     */
    public List<DoctorTime> selectDoctorTimeList(DoctorTime doctorTime);

    /**
     * 新增排班
     * 
     * @param doctorTime 排班
     * @return 结果
     */
    public int insertDoctorTime(DoctorTime doctorTime);

    /**
     * 修改排班
     * 
     * @param doctorTime 排班
     * @return 结果
     */
    public int updateDoctorTime(DoctorTime doctorTime);

    public int updateDoctorMorning(DoctorTime doctorTime);

    public int updateDoctorNoon(DoctorTime doctorTime);
    /**
     * 删除排班
     * 
     * @param id 排班ID
     * @return 结果
     */
    public int deleteDoctorTimeById(Long id);

    /**
     * 批量删除排班
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDoctorTimeByIds(String[] ids);
}
