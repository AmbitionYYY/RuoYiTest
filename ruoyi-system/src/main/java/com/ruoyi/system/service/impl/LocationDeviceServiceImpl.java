package com.ruoyi.system.service.impl;

import com.ruoyi.common.constant.DeviceConstants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.entity.LocationDevice;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.mapper.LocationDeviceMapper;
import com.ruoyi.system.service.LocationDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author JXY
 * @Date 2021/4/15 16:43
 * @Version 1.0
 **/
@Service
public class LocationDeviceServiceImpl implements LocationDeviceService {

    @Autowired
    private LocationDeviceMapper locationDeviceMapper;

    /**
     * @Description 校验设备号是否重复,校验码为0代表不重复，1代表重复
     * @Author JXY
     * @Date 15:09 2021/4/16
     * @param
     * @return
     **/
    @Override
    public String checkDeviceIdUnique(String deviceId) {
        int count = locationDeviceMapper.selectDeviceByDeviceId(deviceId);
        if (count > 0) {
            return DeviceConstants.DEVICE_ID_NOT_UNIQUE;
        }
        return DeviceConstants.DEVICE_ID_UNIQUE;
    }

    /**
     * @Description 查询数据库中已有的设备
     * @Author JXY
     * @Date 18:53 2021/4/16
     * @param  ： 查询分页条件
     * @return  设备数据列表
     **/
    @Override
    public List<LocationDevice> selectDeviceList(LocationDevice device) {
        List<LocationDevice> deviceList = locationDeviceMapper.selectDeviceList(device);
        return deviceList;
    }

    /**
     * @Description 保存新增的设备信息
     * @Author JXY
     * @Date 16:16 2021/4/16
     * @param
     * @return
     **/
    @Override
    @Transactional
    public int insertDevice(LocationDevice device) {
        // 新增设备信息
        int rows = locationDeviceMapper.insertDevice(device);
        return rows;
    }
    /**
     * @Description 根据设备Id查询设备信息
     * @Author JXY
     * @Date 9:51 2021/4/20
     * @param ：设备id
     * @return  :设备信息
     **/

    @Override
    public LocationDevice selectDeviceBydId(int dId) {

        return locationDeviceMapper.selectDeviceBydId(dId);
    }

    /**
     * @Description 保存修改设备信息
     * @Author JXY
     * @Date 14:36 2021/4/19
     * @param
     * @return  结果
     **/
    @Override
    @Transactional
    public int updateDevice(LocationDevice device) {
        device.setUpdateBy(ShiroUtils.getLoginName());
        return locationDeviceMapper.updateDevice(device);
    }

    /**
     * @Description 根据设备号删除设备
     * @Author JXY
     * @Date 16:37 2021/4/19
     * @param
     * @return
     **/
    @Override
    public int deleteDeviceBydId(int dId) {

        return locationDeviceMapper.deleteDeviceBydId(dId);
    }

    /**
     * @Description 批量删除设备
     * @Author JXY
     * @Date 15:24 2021/4/20
     * @param
     * @return
     **/
    @Override
    public int deleteDeviceBydIds(String ids) {

        Integer[] deviceDids= Convert.toIntArray(ids);
        return locationDeviceMapper.deleteDeviceByIds(deviceDids);
    }
    /**
     * @Description 通过设备号更新设备Ip
     * @Author JXY
     * @Date 16:10 2021/4/22
     * @param :需要修改的设备集合
     * @return
     **/
    @Override
    @Transactional
    public int saveAllDeviceIp(List<LocationDevice> list) {
         for (int i=0;i<list.size();i++){
            LocationDevice device = list.get(i);
            //update
             locationDeviceMapper.updateIpByDeviceId(device);
        }
         return list.size();
    }
}
