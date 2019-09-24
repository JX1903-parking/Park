package com.park.mapper;

import com.park.entity.TblBackUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface TollmanMapper {
    public TblBackUser tollmanLogin(@Param("userid") String userid, @Param("upass") String upass);

}
