package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PatientOrder;

/**
 * 挂号Mapper接口
 *
 * @author tanchong
 * @date 2020-09-15
 */
public interface PatientOrderMapper
{
    /**
     * 查询挂号
     *
     * @param orderId 挂号ID
     * @return 挂号
     */
    public PatientOrder selectPatientOrderById(Long orderId);

    /**
     * 查询挂号列表
     *
     * @param patientOrder 挂号
     * @return 挂号集合
     */
    public List<PatientOrder> selectPatientOrderList(PatientOrder patientOrder);

    /**
     * 新增挂号
     *
     * @param patientOrder 挂号
     * @return 结果
     */
    public int insertPatientOrder(PatientOrder patientOrder);

    /**
     * 修改挂号
     *
     * @param patientOrder 挂号
     * @return 结果
     */
    public int updatePatientOrder(PatientOrder patientOrder);

    /**
     * 删除挂号
     *
     * @param orderId 挂号ID
     * @return 结果
     */
    public int deletePatientOrderById(Long orderId);

    /**
     * 批量删除挂号
     *
     * @param orderIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePatientOrderByIds(String[] orderIds);
}