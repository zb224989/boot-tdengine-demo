package cn.ethan.tdengine.example.dao;

import cn.ethan.tdengine.example.domain.DeviceMonitor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceMonitorMapper {

    /**
     * drop db
     */
    void dropDB();

    /**
     * create db
     */
    void createDB();

    /**
     * create super table
     */
    void createSuperTable();

    /**
     * create super table
     */
    void createTable(DeviceMonitor deviceMonitor);

    /**
     * page query
     */
    List<DeviceMonitor> select(@Param("limit") Long limit, @Param("offset") Long offset);

    /**
     * insert
     */
    int insert(DeviceMonitor deviceMonitor);

    int insertBatch(List<DeviceMonitor> deviceMonitorList);

    int count();

    List<String> getSubTables();

    List<DeviceMonitor> avg();

}
