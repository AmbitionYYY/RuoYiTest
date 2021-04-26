package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.entity.LocationDevice;

import java.util.List;

/**
 * @Author JXY
 * @Date 2021/4/15 16:43
 * @Version 1.0
 **/
public interface LocationDeviceService {

    String checkDeviceIdUnique(String deviceId);

    /**
     * @Description 分页查询设备列表数据
     * @Author JXY
     * @Date 19:10 2021/4/15
     * @param ：设备数据集合
     * @return：设备数据列表
     **/
     List<LocationDevice> selectDeviceList(LocationDevice device);

     int insertDevice(LocationDevice device);

     LocationDevice selectDeviceBydId(int dId);

     int updateDevice(LocationDevice device);

     int deleteDeviceBydId(int dId);

    int deleteDeviceBydIds(String ids);

    int saveAllDeviceIp(List<LocationDevice> list);
}
