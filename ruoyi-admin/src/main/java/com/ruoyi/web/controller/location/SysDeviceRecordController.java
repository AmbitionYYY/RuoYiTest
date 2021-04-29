package com.ruoyi.web.controller.location;

import java.util.List;

import com.ruoyi.system.service.ISysDeviceRecordService;
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
import com.ruoyi.system.domain.SysDeviceRecord;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2021-04-28
 */
@Controller
@RequestMapping("/location/record")
public class SysDeviceRecordController extends BaseController
{
    private String prefix = "location/record";

    @Autowired
    private ISysDeviceRecordService sysDeviceRecordService;

    @RequiresPermissions("location:record:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/record";
    }

    /**
     * 查询下发列表数据
     */
    @RequiresPermissions("location:record:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysDeviceRecord sysDeviceRecord)
    {
        startPage();
        List<SysDeviceRecord> list = sysDeviceRecordService.selectSysDeviceRecordList(sysDeviceRecord);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("location:record:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysDeviceRecord sysDeviceRecord)
    {
        List<SysDeviceRecord> list = sysDeviceRecordService.selectSysDeviceRecordList(sysDeviceRecord);
        ExcelUtil<SysDeviceRecord> util = new ExcelUtil<SysDeviceRecord>(SysDeviceRecord.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
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
    @RequiresPermissions("location:record:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysDeviceRecord sysDeviceRecord)
    {
        return toAjax(sysDeviceRecordService.insertSysDeviceRecord(sysDeviceRecord));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{dId}")
    public String edit(@PathVariable("dId") Long dId, ModelMap mmap)
    {
        SysDeviceRecord sysDeviceRecord = sysDeviceRecordService.selectSysDeviceRecordById(dId);
        mmap.put("sysDeviceRecord", sysDeviceRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("location:record:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysDeviceRecord sysDeviceRecord)
    {
        return toAjax(sysDeviceRecordService.updateSysDeviceRecord(sysDeviceRecord));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("location:record:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysDeviceRecordService.deleteSysDeviceRecordByIds(ids));
    }
}
