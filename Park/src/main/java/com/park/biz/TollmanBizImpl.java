package com.park.biz;

import com.park.entity.TblBackUser;
import com.park.mapper.TollmanMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("tollmanBiz")
public class TollmanBizImpl implements TollmanBiz{
@Resource
private TollmanMapper tollmanMapper;
    @Override
    public TblBackUser tollmanLogin(String userid, String upass) {
        TblBackUser backUser = tollmanMapper.tollmanLogin(userid,upass);
        return backUser;
    }
}
