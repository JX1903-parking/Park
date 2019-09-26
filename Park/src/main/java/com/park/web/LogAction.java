package com.park.web;

import com.park.aoplog.Log;
import com.park.biz.LogBiz;
import com.park.entity.TblLog;
import com.park.entity.TblUser;
import com.park.entity.TblUserList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/log")
public class LogAction {

    @Resource
    private LogBiz logBiz;


    @Log(operationType = "日志管理", operationName = "查询数据库日志数据，存储在map，返回前台", module = "系统管理")
    @RequestMapping(value = "/findByLog.action")
    public @ResponseBody
    Map<String, Object> findByLog(HttpServletRequest request, TblUserList userList) {

        int limit = userList.getLimit();
        int page = userList.getPage();

        int count = logBiz.getLogCount(userList);

        int pagenum = count % limit == 0 ? count / limit : count / limit + 1;
        if (page > (pagenum)) {
            if (0 < (page - 1))
                page--;
        }
        userList.setPage((page - 1) * limit);

        List<TblLog> loglist = logBiz.findLogAll(userList);

        Map<String, Object> logmap = new HashMap<String, Object>();
        logmap.put("code", 0);
        logmap.put("count", count);
        logmap.put("data", loglist);

        return logmap;
    }
}
