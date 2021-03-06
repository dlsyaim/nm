package com.soholy.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.soholy.entity.TDeviceRecord;
import com.soholy.mapper.TDeviceDataWifiMapper;
import com.soholy.mapper.TDeviceInfoMapper;
import com.soholy.mapper.TDeviceRecordMapper;
import com.soholy.pojo.aep.vo_v2.TData;
import com.soholy.pojo.aep.vo_v2.TDataWifi;
import com.soholy.service.AepCbService;
import com.soholy.service.activemq.producer.AmqProducer;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Log
public class AepCbServiceImpl implements AepCbService {

    @Autowired
    private TDeviceRecordMapper tDeviceRecordMapper;

    @Autowired
    private TDeviceInfoMapper tDeviceInfoMapper;

    @Autowired
    private TDeviceDataWifiMapper tDeviceDataWifiMapper;

    private static ExecutorService threadPool;

    static {
        //初始化线程池
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int theraPollLength = availableProcessors <= 4 ? availableProcessors : 4;
        threadPool = Executors.newFixedThreadPool(theraPollLength);
    }


    @Override
    public void deviceDatasChangedMsg_v2(JSONObject json) {
        //数据初步处理
        threadPool.execute(new AmqProducer(json));
    }

    @Override
    @Transactional
    public <T extends TData> boolean saveDatas(List<T> data) {
        if (data != null && data.size() > 0) {
            String traceId = tDeviceInfoMapper.selectTraceIdByDeviceNo(data.get(0).getDeviceNo());
            Boolean bl = data.stream().map(x -> {
                try {
                    TDeviceRecord r = new TDeviceRecord();
                    r.setDataTime(x.getDataTime());
                    r.setCreateDate(LocalDateTime.now());
                    r.setDataType(x.getDataType());
                    r.setDeviceNo(x.getDeviceNo());
                    r.setId(x.getId());
                    r.setTraceId(x.getTraceId());
                    r.setLat(x.getLat());
                    r.setLng(x.getLng());
                    r.setVoltage(Double.valueOf(x.getVoltage()));
                    r.setQuantity(x.getQuantity());
                    r.setUploadTime(x.getUploadTime());
                    String temp = traceId != null ? traceId : "0";
                    r.setTraceId(temp);
                    return r;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }).filter(x -> x != null)
                    .map(x -> 1 == tDeviceRecordMapper.insert(x))
                    .reduce(true, (x, y) -> x && y);
            if (!bl) {
                log.warning("数据保存失败！");
                throw new RuntimeException("数据保存失败！");
            }
        }
        return true;
    }

    @Override
    public boolean saveWifis(List<TDataWifi> w1) {
        if (w1 != null && w1.size() > 0) {
            if (w1.size() != w1.stream()
                    .map(x -> tDeviceDataWifiMapper.insert(x))
                    .reduce(0, (x, y) -> x + y)) {
                log.warning("wifi数据保存失败！");
                throw new RuntimeException("wifi数据保存失败！");
            }
        }
        return true;
    }

}
