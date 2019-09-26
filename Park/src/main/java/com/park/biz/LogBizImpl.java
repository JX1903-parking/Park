package com.park.biz;

import com.park.entity.TblLog;
import com.park.entity.TblUserList;
import com.park.mapper.LogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("logBiz")
public class LogBizImpl implements LogBiz {

    @Resource
    private LogMapper logMapper;

    /**
     * @param log
     * @return
     * @deprecated 添加日志信息
     */
    @Override
    public Integer addLog(TblLog log) {
        return logMapper.addLog(log);
    }

    /**
     * @return
     * @deprecated 查询日志信息
     */
    public List<TblLog> findLogAll(TblUserList userList) {
        return logMapper.findLogAll(userList);
    }


    public Integer getLogCount(TblUserList userList){
        return logMapper.getLogCount(userList);
    }

}
