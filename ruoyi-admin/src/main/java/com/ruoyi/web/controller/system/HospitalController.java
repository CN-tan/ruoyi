package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Hospital;
import com.ruoyi.system.service.IHospitalService;
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
@RequestMapping("/system/hospital")
public class HospitalController extends BaseController
{
    private String prefix = "system/hospital";

    @Autowired
    private IHospitalService hospitalService;

    @RequiresPermissions("system:hospital:view")
    @GetMapping()
    public String hospital()
    {
        return prefix + "/hospital";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:hospital:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Hospital hospital)
    {
        startPage();
        List<Hospital> list = hospitalService.selectHospitalList(hospital);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:hospital:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Hospital hospital)
    {
        List<Hospital> list = hospitalService.selectHospitalList(hospital);
        ExcelUtil<Hospital> util = new ExcelUtil<Hospital>(Hospital.class);
        return util.exportExcel(list, "hospital");
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
    @RequiresPermissions("system:hospital:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Hospital hospital)
    {
        return toAjax(hospitalService.insertHospital(hospital));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{hospitalId}")
    public String edit(@PathVariable("hospitalId") Long hospitalId, ModelMap mmap)
    {
        Hospital hospital = hospitalService.selectHospitalById(hospitalId);
        mmap.put("hospital", hospital);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:hospital:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Hospital hospital)
    {
        return toAjax(hospitalService.updateHospital(hospital));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:hospital:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hospitalService.deleteHospitalByIds(ids));
    }
}
