package com.ruoyi.web.controller.location;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.DeviceConstants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.LocationDevice;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.LocationDeviceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author JXY
 * @Date 2021/4/23 17:26
 * @Version 1.0
 **/
@Controller
@RequestMapping("/location/device")
public class LocationDeviceController extends BaseController {
    private String prefix = "location/device";

    @Autowired
    LocationDeviceService locationDeviceService;

    @RequiresPermissions("location:device:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/device";
    }

    /**
     * @Description 进入页面模糊查询分页显示数据
     * @Author JXY
     * @Date 18:16 2021/4/23
     * @param   ；模糊查询设备对象
     * @return  数据列表
     **/
    @RequiresPermissions("location:device:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LocationDevice device)
    {
        startPage();
        List<LocationDevice> list = locationDeviceService.selectDeviceList(device);
        return getDataTable(list);
    }


    /**
     * @Description 新增设备
     * @Author JXY
     * @Date 18:56 2021/4/23
     * @param
     * @return
     **/
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * @Description 保存新增设备
     * @Author JXY
     * @Date 18:22 2021/4/23
     * @param  ：设备对象
     * @return
     **/
    @RequiresPermissions("location:device:add")
    @Log(title = "设备管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated LocationDevice device)
    {
        if (DeviceConstants.DEVICE_ID_NOT_UNIQUE.equals(locationDeviceService.checkDeviceIdUnique(device.getDeviceId())))
        {
            return error("新增设备'" + device.getDeviceId() + "'失败，此设备号已存在");
        }

        return toAjax(locationDeviceService.insertDevice(device));
    }

    /**
     * 修改设备
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int dId, ModelMap mmap){
        LocationDevice device = locationDeviceService.selectDeviceBydId(dId);
        mmap.put("device",device);
        return prefix + "/edit";
    }


    /**
     * @Description 修改保存用户
     * @Author JXY
     * @Date 19:33 2021/4/23
     * @param  ：修改后的表单数据
     * @return
     **/
    @RequiresPermissions("location:device:edit")
    @Log(title = "设备管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated LocationDevice device)
    {
        return toAjax(locationDeviceService.updateDevice(device));
    }


    /**
     * @Description 根据设备号删除设备
     * @Author JXY
     * @Date 18:18 2021/4/23
     * @param   ：选取的设备Id拼接成字符串
     * @return
     **/
    @RequiresPermissions("location:device:remove")
    @Log(title = "设备管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(locationDeviceService.deleteDeviceBydIds(ids));
    }

    /**
     * @Description 通过设备号批量修改设备Ip
     * @Author JXY
     * @Date 10:54 2021/4/26
     * @param   :设备号和设备Ip
     * @return
     **/
    @RequiresPermissions("location:device:editAllDeviceIp")
    @Log(title = "设备管理", businessType = BusinessType.UPDATE)
    @PostMapping("/editAllDeviceIp")
    @ResponseBody
    public AjaxResult saveDeviceIp(@RequestBody List<LocationDevice> list){
        return toAjax(locationDeviceService.saveAllDeviceIp(list));
    }
}
