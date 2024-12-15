package cn.ethan.tdengine.example.service;

import cn.ethan.tdengine.example.dao.DeviceMonitorMapper;
import cn.ethan.tdengine.example.domain.DeviceMonitor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceMonitorService {

    private final DeviceMonitorMapper deviceMonitorMapper;

    public DeviceMonitorService(DeviceMonitorMapper deviceMonitorMapper) {
        this.deviceMonitorMapper = deviceMonitorMapper;
    }

    public int init() throws Exception{
        deviceMonitorMapper.dropDB();
        deviceMonitorMapper.createDB();
        deviceMonitorMapper.createSuperTable();

        // create table
        DeviceMonitor deviceMonitor1 = new DeviceMonitor(1, 1, "a001");
        deviceMonitorMapper.createTable(deviceMonitor1);
        // insert data
        Thread.sleep(500);
        deviceMonitor1.setData(25.3f, 60.1f, 5.2f, 220f);
        deviceMonitorMapper.insert(deviceMonitor1);
        Thread.sleep(500);
        deviceMonitor1.setData(25.4f, 59.9f, 5.3f, 219f);
        deviceMonitorMapper.insert(deviceMonitor1);


        // create table
        DeviceMonitor deviceMonitor2 = new DeviceMonitor(1, 1, "a002");
        deviceMonitorMapper.createTable(deviceMonitor2);
        // insert data
        Thread.sleep(500);
        deviceMonitor2.setData(24.8f, 58.7f, 4.8f, 218f);
        Thread.sleep(500);
        deviceMonitor2.setData(24.9f, 58.5f, 4.9f, 220f);
        deviceMonitorMapper.insert(deviceMonitor2);
        return 1;
    }

    public List<DeviceMonitor> query(Long limit, Long offset) {
        return deviceMonitorMapper.select(limit, offset);
    }

    public int save(String deviceId, float temperature, float humidity, float current, float voltage) {
        DeviceMonitor deviceMonitor = new DeviceMonitor();
        deviceMonitor.setDeviceId(deviceId);
        deviceMonitor.setData(temperature, humidity, current, voltage);
        return deviceMonitorMapper.insert(deviceMonitor);
    }

    public int saveBatch(List<DeviceMonitor> deviceMonitorList) {
        return deviceMonitorMapper.insertBatch(deviceMonitorList);
    }

    public int count() {
        return deviceMonitorMapper.count();
    }

    public List<String> getSubTables() {
        return deviceMonitorMapper.getSubTables();
    }

    public List<DeviceMonitor> avg() {
        return deviceMonitorMapper.avg();
    }
}
