package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【设备修改下发对象】对象 sys_device_record
 * 
 * @author ruoyi
 * @date 2021-04-28
 */
public class SysDeviceRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long rId;

    /** 设备ID */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private int dId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String deviceId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String originalIp;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String modifiedIp;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String manufacturer;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer successFlag;

    public void setrId(Long rId)
    {
        this.rId = rId;
    }

    public Long getrId()
    {
        return rId;
    }
    public void setDeviceId(String deviceId) 
    {
        this.deviceId = deviceId;
    }

    public String getDeviceId() 
    {
        return deviceId;
    }
    public void setOriginalIp(String originalIp) 
    {
        this.originalIp = originalIp;
    }

    public String getOriginalIp() 
    {
        return originalIp;
    }
    public void setModifiedIp(String modifiedIp) 
    {
        this.modifiedIp = modifiedIp;
    }

    public String getModifiedIp() 
    {
        return modifiedIp;
    }
    public void setManufacturer(String manufacturer) 
    {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() 
    {
        return manufacturer;
    }
    public void setSuccessFlag(Integer successFlag) 
    {
        this.successFlag = successFlag;
    }

    public Integer getSuccessFlag() 
    {
        return successFlag;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dId", getrId())
            .append("deviceId", getDeviceId())
            .append("originalIp", getOriginalIp())
            .append("modifiedIp", getModifiedIp())
            .append("manufacturer", getManufacturer())
            .append("updateTime", getUpdateTime())
            .append("successFlag", getSuccessFlag())
            .append("dId", getdId())
            .toString();
    }
}
