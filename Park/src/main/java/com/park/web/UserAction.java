package com.park.web;

import com.park.biz.FrontUserBiz;
import com.park.biz.UserBiz;
import com.park.entity.TblBackUser;
import com.park.entity.TblUser;
import com.park.entity.TblUserList;
import com.park.tools.DateTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserAction {
    @Resource
    private UserBiz userBiz;
    @Resource
    private FrontUserBiz frontUserBiz;

    /**
     * @param request
     * @param begintime
     * @param endtime
     * @param keyword
     * @param page
     * @param limit
     * @return
     * @deprecated
     */
    @RequestMapping(value = "/findAllBackUser.action", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody
    Map<String, Object> findAllBackUser(HttpServletRequest request, String begintime, String endtime, String keyword, int page, int limit) {
        System.out.println("进入Action");
        Map<String, Object> paramap = new HashMap<String, Object>();
        System.out.println(begintime + " " + endtime + " " + keyword + " " + page + " " + limit);

        paramap.put("begintime", begintime);
        paramap.put("endtime", endtime);
        paramap.put("keyword", keyword);
        page = (page - 1) * limit;
        paramap.put("page", page);
        paramap.put("limit", limit);
        int count = userBiz.getCount(paramap);
        System.out.println("count" + count);
        List<TblBackUser> backUserList = userBiz.findAllBackUser(paramap);
        String[] strArr = DateTool.getDate().substring(0, DateTool.getDate().lastIndexOf(" ")).split("-");
        int currentY = Integer.parseInt(strArr[0]);
        int currentM = Integer.parseInt(strArr[1]);
        int currentD = Integer.parseInt(strArr[2]);
        int worktime = 0;
        String[] regArr = null;
        for (TblBackUser backUser : backUserList
        ) {
            regArr = backUser.getRegtime().substring(0, backUser.getRegtime().lastIndexOf(" ")).split("-");
            int regY = Integer.parseInt(regArr[0]);
            int regM = Integer.parseInt(regArr[1]);
            int regD = Integer.parseInt(regArr[2]);
            System.out.println(currentY + " " + regY);
            worktime = currentM == regM ? (currentD >= regD ? currentY - regY : currentY - regY - 1) : (currentM > regM ? currentY - regY : currentY - regY - 1);
            backUser.setWorktime(worktime);
        }
        HashMap<String, Object> remap = new HashMap<String, Object>();

        remap.put("code", 0);
        remap.put("count", count);
        remap.put("data", backUserList);
        return remap;
    }

    @RequestMapping(value = "/updateBackUserParam.action", method = RequestMethod.POST, produces = "application/text;charset=utf-8")
    public @ResponseBody
    String updateBackUserParam(HttpServletRequest request, String userid, int paramid) {
        String remsg = null;
        int num = userBiz.updateBackUserParam(userid, paramid);
        if (num > 0) {
            remsg = "1";
        } else {
            remsg = "0";
        }
        return remsg;
    }

    @RequestMapping(value = "/findBackUserById.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public @ResponseBody
    TblBackUser findBackUserById(HttpServletRequest request, String userid) {
        TblBackUser backUser = userBiz.findBackUserById(userid);
        return backUser;
    }

    @RequestMapping(value = "/freshBackUser.action", method = RequestMethod.POST, produces = "application/text;charset=utf-8")
    public @ResponseBody
    String freshBackUser(HttpServletRequest request, TblBackUser backUser, String title) {
        System.out.println("进入新增/修改");
        String remsg = null;
        System.out.println("标题" + title);
        backUser.setRoleid(10);
        String regtime = DateTool.getDate();
        backUser.setRegtime(regtime);
        int num = userBiz.freshBackUser(backUser, title);
        if (num > 0) {
            remsg = "1";
        } else {
            remsg = "0";
        }
        return remsg;
    }

    /**
     * @param request
     * @param userList
     * @return
     * @deprecated 查询前台用户列表
     */

    @RequestMapping(value = "/findByUser.action")
    public @ResponseBody
    Map<String, Object> findByUser(HttpServletRequest request, TblUserList userList) {

        int limit = userList.getLimit();
        int page = userList.getPage();
        int count = frontUserBiz.getUserCount(userList);
        int pagenum = count % limit == 0 ? count / limit : count / limit + 1;
        if (page > (pagenum)) {
            if (0 < (page - 1))
                page--;
        }
        userList.setPage((page - 1) * limit);

        List<TblUser> ulist = frontUserBiz.findByUser(userList);

        Map<String, Object> usermap = new HashMap<String, Object>();
        usermap.put("code", 0);
        usermap.put("count", count);
        usermap.put("data", ulist);

        return usermap;

    }


    /**
     * @param userid
     * @return
     * @deprecated 修改前台用户账号
     */

    @RequestMapping(value = "/UpdateUserStatus.action", method = RequestMethod.POST, produces = "application/text;charset=utf-8")
    public @ResponseBody
    String UpdateUserStatus(String userid, String paramid) {
        int num = 0;
        num = frontUserBiz.UpdateUserStatus(Integer.parseInt(paramid), userid);

        return String.valueOf(num);
    }

    @RequestMapping(value = "/findUserById.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public @ResponseBody
    TblUser findUserById(HttpServletRequest request, String userid) {
        TblUser user = frontUserBiz.findUserById(userid);
        return user;
    }

    @RequestMapping(value = "/updateUser.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public @ResponseBody
    String updateUser(HttpServletRequest request, TblUser user) {
        int num  = frontUserBiz.updateUser(user);
        return String.valueOf(num);
    }

}
