package cn.ethan.tdengine.example.controller;

import cn.ethan.tdengine.example.domain.DeviceMonitor;
import cn.ethan.tdengine.example.service.DeviceMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/deviceMonitor")
@RestController
public class DeviceMonitorController {

    @Autowired
    private DeviceMonitorService deviceMonitorService;

    /**
     * create database and table (init data)
     */
    @GetMapping("/init")
    public int init() throws Exception {
        return deviceMonitorService.init();
    }

    /**
     * Pagination Query
     * @param limit /
     * @param offset /
     */
    @GetMapping("/{limit}/{offset}")
    public List<DeviceMonitor> queryDeviceMonitor(@PathVariable Long limit, @PathVariable Long offset) {
        return deviceMonitorService.query(limit, offset);
    }

    /**
     * 新增数据
     *
     * @param temperature 温度
     * @param humidity 湿度
     * @param current 电流
     * @param voltage 电压
     */
    @PostMapping("/{deviceId}/{temperature}/{humidity}/{current}/{voltage}")
    public int saveDeviceMonitor(@PathVariable String deviceId,
                                 @PathVariable float temperature,
                                 @PathVariable float humidity,
                                 @PathVariable float current,
                                 @PathVariable float voltage) {
        return deviceMonitorService.save(deviceId, temperature, humidity,current, voltage);
    }


    /**
     * 批量插入
     */
    @PostMapping("/batch")
    public int saveBatchDeviceMonitor(@RequestBody List<DeviceMonitor> deviceMonitorList) {
        return deviceMonitorService.saveBatch(deviceMonitorList);
    }

    /**
     * 查询数量
     */
    @GetMapping("/count")
    public int count() {
        return deviceMonitorService.count();
    }

    /**
     * 获取分表名称
     */
    @GetMapping("/subTables")
    public List<String> getSubTables() {
        return deviceMonitorService.getSubTables();
    }

    /**
     * 获取平均值
     */
    @GetMapping("/avg")
    public List<DeviceMonitor> avg() {
        return deviceMonitorService.avg();
    }

}
