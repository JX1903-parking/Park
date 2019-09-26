package com.park.biz;

import com.park.entity.TblLog;
import com.park.entity.TblUserList;

import java.util.List;

public interface LogBiz {

    public Integer addLog(TblLog log);

    public List<TblLog> findLogAll(TblUserList userList);

    public Integer getLogCount(TblUserList userList);
}
