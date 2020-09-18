package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.DoctorTime;
import com.ruoyi.system.service.IDoctorTimeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 排班Controller
 * 
 * @author tanchong
 * @date 2020-09-17
 */
@Controller
@RequestMapping("/system/time")
public class DoctorTimeController extends BaseController
{
    private String prefix = "system/time";

    @Autowired
    private IDoctorTimeService doctorTimeService;

    @RequiresPermissions("system:time:view")
    @GetMapping()
    public String time()
    {
        return prefix + "/time";
    }

    /**
     * 查询排班列表
     */
    @RequiresPermissions("system:time:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DoctorTime doctorTime)
    {
        startPage();
        List<DoctorTime> list = doctorTimeService.selectDoctorTimeList(doctorTime);
        return getDataTable(list);
    }

    /**
     * 导出排班列表
     */
    @RequiresPermissions("system:time:export")
    @Log(title = "排班", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DoctorTime doctorTime)
    {
        List<DoctorTime> list = doctorTimeService.selectDoctorTimeList(doctorTime);
        ExcelUtil<DoctorTime> util = new ExcelUtil<DoctorTime>(DoctorTime.class);
        return util.exportExcel(list, "time");
    }

    /**
     * 新增排班
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存排班
     */
    @RequiresPermissions("system:time:add")
    @Log(title = "请假", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DoctorTime doctorTime)
    {
        return toAjax(doctorTimeService.insertDoctorTime(doctorTime));
    }

    /**
     * 修改排班
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DoctorTime doctorTime = doctorTimeService.selectDoctorTimeById(id);
        mmap.put("doctorTime", doctorTime);
        return prefix + "/edit";
    }

    /**
     * 修改保存排班
     */
    @RequiresPermissions("system:time:edit")
    @Log(title = "排班", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DoctorTime doctorTime)
    {
        return toAjax(doctorTimeService.updateDoctorTime(doctorTime));
    }

    /**
     * 删除排班
     */
    @RequiresPermissions("system:time:remove")
    @Log(title = "排班", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(doctorTimeService.deleteDoctorTimeByIds(ids));
    }
}
