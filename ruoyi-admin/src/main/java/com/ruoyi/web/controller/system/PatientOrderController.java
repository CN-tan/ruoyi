package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.PatientOrder;
import com.ruoyi.system.service.IPatientOrderService;
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
 * @date 2020-09-07
 */
@Controller
@RequestMapping("/system/order")
public class PatientOrderController extends BaseController
{
    private String prefix = "system/order";

    @Autowired
    private IPatientOrderService patientOrderService;

    @RequiresPermissions("system:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PatientOrder patientOrder)
    {
        startPage();
        List<PatientOrder> list = patientOrderService.selectPatientOrderList(patientOrder);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:order:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PatientOrder patientOrder)
    {
        List<PatientOrder> list = patientOrderService.selectPatientOrderList(patientOrder);
        ExcelUtil<PatientOrder> util = new ExcelUtil<PatientOrder>(PatientOrder.class);
        return util.exportExcel(list, "order");
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
    @RequiresPermissions("system:order:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PatientOrder patientOrder)
    {
        return toAjax(patientOrderService.insertPatientOrder(patientOrder));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{orderId}")
    public String edit(@PathVariable("orderId") Long orderId, ModelMap mmap)
    {
        PatientOrder patientOrder = patientOrderService.selectPatientOrderById(orderId);
        mmap.put("patientOrder", patientOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:order:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PatientOrder patientOrder)
    {
        return toAjax(patientOrderService.updatePatientOrder(patientOrder));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:order:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(patientOrderService.deletePatientOrderByIds(ids));
    }
}
