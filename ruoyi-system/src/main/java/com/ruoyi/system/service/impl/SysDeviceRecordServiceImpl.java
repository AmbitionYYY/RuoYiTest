package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysDeviceRecordMapper;
import com.ruoyi.system.domain.SysDeviceRecord;
import com.ruoyi.system.service.ISysDeviceRecordService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-28
 */
@Service
public class SysDeviceRecordServiceImpl implements ISysDeviceRecordService 
{
    @Autowired
    private SysDeviceRecordMapper sysDeviceRecordMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param dId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public SysDeviceRecord selectSysDeviceRecordById(Long dId)
    {
        return sysDeviceRecordMapper.selectSysDeviceRecordById(dId);
    }

    /**
     * 查询设备IP更改记录列表
     * 
     * @param sysDeviceRecord 【请填写功能名称】
     * @return 【添加厂家描述属性】
     */
    @Override
    public List<SysDeviceRecord> selectSysDeviceRecordList(SysDeviceRecord sysDeviceRecord)
       /* List<SysDeviceRecord> sysDeviceRecords = sysDeviceRecordMapper.selectSysDeviceRecordList(sysDeviceRecord);
        for (int i=0;i<sysDeviceRecords.size();i++){

            SysDeviceRecord deviceRecord = sysDeviceRecords.get(i);
            int dId = deviceRecord.getdId();
            deviceRecord.setManufacturer(sysDeviceRecordMapper.selectSysDeviceRecordManufacturer(dId));
        }*/
//        System.out.println(sysDeviceRecords);
//        return sysDeviceRecords;
    {return sysDeviceRecordMapper.selectSysDeviceRecordList(sysDeviceRecord);}


    /**
     * 新增【请填写功能名称】
     * 
     * @param sysDeviceRecord 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysDeviceRecord(SysDeviceRecord sysDeviceRecord)
    {
        return sysDeviceRecordMapper.insertSysDeviceRecord(sysDeviceRecord);
    }


    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysDeviceRecordByIds(String ids)
    {
        return sysDeviceRecordMapper.deleteSysDeviceRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param dId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteSysDeviceRecordById(Long dId)
    {
        return sysDeviceRecordMapper.deleteSysDeviceRecordById(dId);
    }
}
