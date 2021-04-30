package com.ruoyi.system.mapper;

import com.ruoyi.common.core.domain.entity.LocationDevice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author JXY
 * @Date 2021/4/15 16:50
 * @Version 1.0
 **/
@Component
public interface LocationDeviceMapper {

    /**
     * @param :设备查询数据条件
     * @return 设备查询结果列表
     * @Description 根据条件分页查询设备列表数据
     * @Author JXY
     * @Date 19:04 2021/4/15
     **/
    List<LocationDevice> selectDeviceList(LocationDevice device);

    /**
     * @param
     * @return
     * @Description 用于校验设备是否存在
     * @Author JXY
     * @Date 9:53 2021/4/20
     **/
    int checkDeviceByDeviceId(String deviceId);

    int insertDevice(LocationDevice device);

    /**
     * @param ：设备号
     * @return
     * @Description 根据设备号查询设备，用于编辑设备
     * @Author JXY
     * @Date 10:58 2021/4/19
     **/

    LocationDevice selectDeviceBydId(int dId);

    int updateDevice(LocationDevice device);

    int deleteDeviceBydId(int dId);

    int deleteDeviceByIds(Integer[] deviceDids);

    void updateIpByDeviceId(LocationDevice device);

    /**
     * @param ：设备号
     * @return ：设备对象
     * @Description 通过设备号查询设备数据
     * @Author JXY
     * @Date 16:29 2021/4/28
     **/
    LocationDevice selectDeviceByDeviceId(String deviceId);
}
