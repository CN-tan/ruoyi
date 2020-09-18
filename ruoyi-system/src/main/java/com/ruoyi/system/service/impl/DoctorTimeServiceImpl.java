package com.ruoyi.system.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.sql.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DoctorTimeMapper;
import com.ruoyi.system.domain.DoctorTime;
import com.ruoyi.system.service.IDoctorTimeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 排班Service业务层处理
 * 
 * @author tanchong
 * @date 2020-09-17
 */
@Service
public class DoctorTimeServiceImpl implements IDoctorTimeService 
{
    @Autowired
    private DoctorTimeMapper doctorTimeMapper;

    /**
     * 查询排班
     * 
     * @param id 排班ID
     * @return 排班
     */
    @Override
    public DoctorTime selectDoctorTimeById(Long id)
    {
        return doctorTimeMapper.selectDoctorTimeById(id);
    }

    /**
     * 查询排班列表
     * 
     * @param doctorTime 排班
     * @return 排班
     */
    @Override
    public List<DoctorTime> selectDoctorTimeList(DoctorTime doctorTime)
    {
        return doctorTimeMapper.selectDoctorTimeList(doctorTime);
    }

    /**
     * 新增排班
     * 
     * @param doctorTime 排班
     * @return 结果
     */
    @Override
    public int insertDoctorTime(DoctorTime doctorTime)
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String currentString=df.format(new Date());
        try{
            long current=SqlUtil.dateToStamp(currentString,"yyyy-MM-dd");
            Long date=(long)SqlUtil.dateToStamp(doctorTime.getDate(),"yyyy-MM-dd");
            if((date-current)<=259200L&&doctorTime.getKind()==0){
                  doctorTimeMapper.updateDoctorMorning(doctorTime);
            }else if ((date-current)<=259200L&&doctorTime.getKind()==1){
                  doctorTimeMapper.updateDoctorNoon(doctorTime);
            }
        }catch (ParseException e){
            System.out.println(e.getStackTrace());
        }
        return doctorTimeMapper.insertDoctorTime(doctorTime);
    }

    /**
     * 修改排班
     * 
     * @param doctorTime 排班
     * @return 结果
     */
    @Override
    public int updateDoctorTime(DoctorTime doctorTime)
    {
        return doctorTimeMapper.updateDoctorTime(doctorTime);
    }

    /**
     * 删除排班对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDoctorTimeByIds(String ids)
    {
        return doctorTimeMapper.deleteDoctorTimeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除排班信息
     * 
     * @param id 排班ID
     * @return 结果
     */
    @Override
    public int deleteDoctorTimeById(Long id)
    {
        return doctorTimeMapper.deleteDoctorTimeById(id);
    }
}
