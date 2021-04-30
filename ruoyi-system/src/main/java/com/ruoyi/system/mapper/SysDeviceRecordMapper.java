package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.SysDeviceRecord;
import org.springframework.stereotype.Component;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2021-04-28
 */
@Component
public interface SysDeviceRecordMapper {
    /**
     * 查询【请填写功能名称】
     *
     * @param dId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public SysDeviceRecord selectSysDeviceRecordById(Long dId);

    /**
     * 根据条件模糊查询返回记录对象列表
     *
     * @param sysDeviceRecord 【记录对象查询条件】
     * @return 设备记录对象集合
     */
    public List<SysDeviceRecord> selectSysDeviceRecordList(SysDeviceRecord sysDeviceRecord);

    /**
     * 新增设备修改记录数据
     *
     * @param sysDeviceRecord 修改设备记录对象
     * @return 结果
     */
    public int insertSysDeviceRecord(SysDeviceRecord sysDeviceRecord);

    /**
     * 修改设备记录
     *
     * @param sysDeviceRecord 设备记录对象
     * @return 结果
     */
    public String selectSysDeviceRecordManufacturer(int dId);

    /**
     * 删除【请填写功能名称】
     *
     * @param dId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteSysDeviceRecordById(Long dId);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param dIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysDeviceRecordByIds(String[] dIds);

    /**
     * @Description 更新单个记录数据
     * @Author JXY
     * @Date 19:56 2021/4/29
     * @param
     * @return
     **/
    void updateOneSysDeviceRecord(long rId);
}
