package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Doctor;
import com.ruoyi.system.domain.Patient;
import com.ruoyi.system.service.IPatientService;
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
@RequestMapping("/system/patient")
public class PatientController extends BaseController
{
    private String prefix = "system/patient";

    @Autowired
    private IPatientService patientService;

    @RequiresPermissions("system:patient:view")
    @GetMapping()
    public String patient()
    {
        return prefix + "/patient";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:patient:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Patient patient)
    {
        startPage();
        List<Patient> list = patientService.selectPatientList(patient);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:patient:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Patient patient)
    {
        List<Patient> list = patientService.selectPatientList(patient);
        ExcelUtil<Patient> util = new ExcelUtil<Patient>(Patient.class);
        return util.exportExcel(list, "patient");
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
    @RequiresPermissions("system:patient:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Patient patient)
    {
        return toAjax(patientService.insertPatient(patient));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{idNumber}")
    public String edit(@PathVariable("idNumber") String idNumber, ModelMap mmap)
    {
        Patient patient = patientService.selectPatientById(idNumber);
        mmap.put("patient", patient);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:patient:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Patient patient)
    {
        return toAjax(patientService.updatePatient(patient));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:patient:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(patientService.deletePatientByIds(ids));
    }


    @PostMapping("/checkIdNumberUnique")
    @ResponseBody
    public String checkIdNumberUnique(Patient patient)
    {
        return patientService.checkIdNumberUnique(patient.getIdNumber());
    }

    @PostMapping("/checkPatientIdUnique")
    @ResponseBody
    public String checkPatientIdUnique(Patient patient)
    {
        return patientService.checkPatientIdUnique(patient.getPatientId());
    }

    @PostMapping("/checkPhonenumberUnique")
    @ResponseBody
    public String checkPhonenumberUnique(Patient patient)
    {
        return patientService.checkPhonenumberUnique(patient);
    }
}
