package com.park.biz;

import com.park.entity.TblCar;
import com.park.entity.TblUser;

import java.util.List;

public interface WeChatBiz {
    public TblUser login(String userid, String upass);
    public List<TblCar> fendmycar(String userid);
    public String fendByUserid(String userid);
    public String reg(TblUser user);
}
