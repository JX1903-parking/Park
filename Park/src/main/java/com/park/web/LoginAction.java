package com.park.web;

import com.park.biz.TollmanBiz;
import com.park.biz.UserBiz;
import com.park.entity.TblBackUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginAction {
    @Resource
    private UserBiz userBiz;
    @Resource
    private TollmanBiz tollmanBiz;


    @RequestMapping(value = "/tollmanLogin.action", method = {RequestMethod.POST,RequestMethod.GET}, produces = "application/text;charset=utf-8")
    public @ResponseBody
    String tollmanLogin(HttpServletRequest request, String userid, String upass) {
        String remsg = "fail";
        System.out.println(userid+"222");
        TblBackUser backUser = tollmanBiz.tollmanLogin(userid,upass);
        System.out.println(backUser.getUname() + "==");
        //判断实体是否为空
        if (null != backUser) {
            //判断账号是否被禁用
            if (5==backUser.getStateid()) {
                System.out.println(backUser.getStateid());
                //判断账号是否已被删除
                if (0==backUser.getIsdeleted()) {
                    remsg = "success";
                    request.getSession().setAttribute("backUser", backUser);
                } else {
                    remsg = "Non-exist";
                }
            } else {
                remsg = "Prohibit";
            }
        }

        return remsg;
    }

    @RequestMapping(value = "/backLogin.action", method = RequestMethod.POST, produces = "application/text;charset=utf-8")
    public @ResponseBody
    String backLogin(HttpServletRequest request, String userid, String upass, String securityCode) {
        String remsg = "fail";
        TblBackUser backUser = userBiz.backLogin(userid, upass);

        String serverCode = (String) request.getSession().getAttribute("SESSION_SECURITY_CODE");

        //判断实体是否为空
        if (null != backUser) {
            //判断账号是否被禁用
            if (5 == backUser.getStateid()) {
                //判断账号是否已被删除
                if (0 == backUser.getIsdeleted()) {
                    if (serverCode.equalsIgnoreCase(securityCode)) {
                        remsg = "success";
                        request.getSession().setAttribute("backUser", backUser);
                    } else {
                        remsg = "codefail";
                    }
                } else {
                    remsg = "Non-exist";
                }
            } else {
                remsg = "Prohibit";
            }
        }
        return remsg;
    }
}
