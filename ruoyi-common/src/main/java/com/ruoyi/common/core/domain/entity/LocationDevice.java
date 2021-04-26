package com.ruoyi.common.core.domain.entity;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author JXY
 * @Date 2021/4/15 14:04
 * @Version 1.0
 **/

public class LocationDevice extends BaseEntity  {

    private static final long serialVersionUID = 6570030031348701765L;
    /**
     * 设备id
     */
    private int dId;
    /**
     * 设备号
     */
    @NotBlank(message = "设备号不能为空！")
    private String deviceId;
    /**
     * 设备IP
     */
    @NotBlank(message = "设备IP不能为空！")
    private String deviceIp;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;
    /**
     * 生产厂家
     */
    private String manufacturer;
    /**
     * 设备描述
     */
    private String description;

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)

                .append("delFlag" , getDelFlag())
                .append("createBy" , getCreateBy())
                .append("updateBy" , getUpdateBy())
                .append("createTime" , getCreateTime())
                .append("updateTime" , getUpdateTime())
                .append("remark" , getRemark())
                .append("deviceId" , getDeviceId())
                .append("deviceIp" , getDeviceIp())
                .append("manufacturer" , getManufacturer())
                .append("description" , getDescription())
                .append("did" , getdId())
                .toString();
    }
}
