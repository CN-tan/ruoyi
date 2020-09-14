package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Doctor;
import com.ruoyi.system.domain.DoctorWithDepartment;
import com.ruoyi.system.service.IDoctorService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
@Controller
@RequestMapping("/system/doctor")
public class DoctorController extends BaseController
{
    private String prefix = "system/doctor";

    @Autowired
    private IDoctorService doctorService;

    @RequiresPermissions("system:doctor:view")
    @GetMapping()
    public String doctor()
    {
        return prefix + "/doctor";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:doctor:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DoctorWithDepartment doctor)
    {
        startPage();
        List<DoctorWithDepartment> list = doctorService.selectDoctorList(doctor);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:doctor:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DoctorWithDepartment doctor)
    {
        List<DoctorWithDepartment> list = doctorService.selectDoctorList(doctor);
        ExcelUtil<DoctorWithDepartment> util = new ExcelUtil<DoctorWithDepartment>(DoctorWithDepartment.class);
        return util.exportExcel(list, "doctor");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:doctor:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Doctor doctor)
    {
        return toAjax(doctorService.insertDoctor(doctor));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{doctorId}")
    public String edit(@PathVariable("doctorId") Long doctorId, ModelMap mmap)
    {
        DoctorWithDepartment doctor = doctorService.selectDoctorById(doctorId);
        mmap.put("doctor", doctor);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:doctor:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Doctor doctor)
    {
        return toAjax(doctorService.updateDoctor(doctor));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:doctor:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(doctorService.deleteDoctorByIds(ids));
    }

    @PostMapping("/checkDoctorIdUnique")
    @ResponseBody
    public String checkDoctorIdUnique(Doctor doctor)
    {
        return doctorService.checkDoctorIdUnique(doctor.getDoctorId());
    }

    @PostMapping("/checkHospitalExists")
    @ResponseBody
    public String checkHospitalExists(Doctor doctor){
        return doctorService.checkHospitalExists(doctor.getHospitalName());
    }

    @PostMapping("/checkDepartmentExists")
    @ResponseBody
    public String checkDepartmentExists(Doctor doctor){
        return doctorService.checkDepartmentExists(doctor);
    }
}
