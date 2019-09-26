package com.park.mapper;

import com.park.entity.TblCar;
import com.park.entity.TblUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeChatMapper {
    public TblUser login(@Param("userid") String userid, @Param("upass") String upass);
    public List<TblCar> fendmycar(String userid);
    public List <TblUser> fendByUserid(String userid);
    public int reg(TblUser user);
}
