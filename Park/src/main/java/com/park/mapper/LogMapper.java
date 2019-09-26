package com.park.mapper;

import com.park.entity.TblLog;
import com.park.entity.TblUserList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogMapper {

    public Integer addLog(TblLog log);


    public List<TblLog> findLogAll(TblUserList userList);

    public Integer getLogCount(TblUserList userList);

}
