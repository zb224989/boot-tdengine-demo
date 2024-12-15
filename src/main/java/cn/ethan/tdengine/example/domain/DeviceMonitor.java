package cn.ethan.tdengine.example.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceMonitor {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Timestamp ts;

    /**
     * 温度
     */
    private Float temperature;

    /**
     * 湿度
     */
    private Float humidity;

    /**
     * 电流
     */
    private Float current;

    /**
     * 电压
     */
    private Float voltage;

    /**
     * 工厂ID
     */
    private Integer factoryId;
    /**
     * 车间ID
     */
    private Integer workshopId;
    /**
     * 设备ID
     */
    private String deviceId;


    public DeviceMonitor() {
    }

    public DeviceMonitor(Integer factoryId, Integer workshopId, String deviceId) {
        this.factoryId = factoryId;
        this.workshopId = workshopId;
        this.deviceId = deviceId;
    }


    public void setData(Float temperature,
                   Float humidity,
                   Float current,
                   Float voltage) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.current = current;
        this.voltage = voltage;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Float getCurrent() {
        return current;
    }

    public void setCurrent(Float current) {
        this.current = current;
    }

    public Float getVoltage() {
        return voltage;
    }

    public void setVoltage(Float voltage) {
        this.voltage = voltage;
    }

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    public Integer getWorkshopId() {
        return workshopId;
    }

    public void setWorkshopId(Integer workshopId) {
        this.workshopId = workshopId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
