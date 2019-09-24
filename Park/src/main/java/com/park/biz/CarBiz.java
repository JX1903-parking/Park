package com.park.biz;

import com.park.entity.TblCar;
import com.park.entity.TblLocation;
import com.park.entity.TblRecord;

import java.util.Map;

public interface CarBiz {
//    进停车场
//    brand（车牌）
    public TblCar selCar(String brand);

    //临时车
    public Integer addCar(TblCar car);

    //安排车位
    public TblLocation selLocation(int locationid);

    //修改车位
    public Integer modCar(Map<String,Object> m);

    //修改车位状态
    public Integer modLocation(int locationid);

    //增加停车流水
    public Integer addRecord(TblRecord record);

    //查找可用车位
    public Integer getLocation();

    //查找总车位
    public Integer getTotal();
}
