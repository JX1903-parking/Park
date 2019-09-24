package com.park.biz;

import com.park.entity.TblCar;
import com.park.entity.TblLocation;
import com.park.entity.TblRecord;
import com.park.mapper.CarMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

@Repository("carBiz")
public class CarBizImpl implements CarBiz {
    @Resource
    private CarMapper carMapper;
    @Override
    public TblCar selCar(String brand) {
        return carMapper.selCar(brand);
    }

    @Override
    public Integer addCar(TblCar car) {
        return carMapper.addCar(car);
    }

    @Override
    public TblLocation selLocation(int locationid) {
        return carMapper.selLocation(locationid);
    }

    @Override
    public Integer modCar(Map<String,Object> m) {
        return carMapper.modCar(m);
    }

    @Override
    public Integer modLocation(int locationid) {
        return carMapper.modLocation(locationid);
    }

    @Override
    public Integer addRecord(TblRecord record) {
        return carMapper.addRecord(record);
    }

    @Override
    public Integer getLocation() {
        return carMapper.getLocation();
    }

    @Override
    public Integer getTotal() {
        return carMapper.getTotal();
    }
}
