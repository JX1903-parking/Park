package com.park.mapper;

import com.park.entity.TblCar;
import com.park.entity.TblLocation;
import com.park.entity.TblRecord;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CarMapper {
    public TblCar selCar(String brand);
    public Integer addCar(TblCar car);
    public TblLocation selLocation(int locationid);
    public Integer modCar(Map<String,Object> m);
    public Integer modLocation(int locationid);
    public Integer addRecord(TblRecord record);
    public Integer getLocation();
    public Integer getTotal();
}
