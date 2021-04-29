package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysDeviceRecord;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2021-04-28
 */
public interface ISysDeviceRecordService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param dId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public SysDeviceRecord selectSysDeviceRecordById(Long dId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysDeviceRecord 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysDeviceRecord> selectSysDeviceRecordList(SysDeviceRecord sysDeviceRecord);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysDeviceRecord 【请填写功能名称】
     * @return 结果
     */
    public int insertSysDeviceRecord(SysDeviceRecord sysDeviceRecord);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysDeviceRecord 【请填写功能名称】
     * @return 结果
     */
    public int updateSysDeviceRecord(SysDeviceRecord sysDeviceRecord);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysDeviceRecordByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param dId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteSysDeviceRecordById(Long dId);
}
