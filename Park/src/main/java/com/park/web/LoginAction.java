package com.park.web;

import com.park.aoplog.Log;
import com.park.biz.TollmanBiz;
import com.park.biz.UserBiz;
import com.park.entity.TblBackUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginAction {
    @Resource
    private UserBiz userBiz;
    @Resource
    private TollmanBiz tollmanBiz;

    private String remsg = "fail";

    /**
     * @param request
     * @param userid
     * @param upass
     * @param securityCode
     * @deprecated 管理员登录，收费员登录
     */
    @Log(operationType = "用户管理", operationName = "管理员登录", module = "系统管理")
    @RequestMapping(value = "/adLogin.action", method = RequestMethod.POST, produces = "application/text;charset=utf-8")
    public @ResponseBody
    String adLogin(HttpServletRequest request, String userid, String upass, String securityCode) {


        TblBackUser backUser = userBiz.backLogin(userid, upass);

        String serverCode = (String) request.getSession().getAttribute("SESSION_SECURITY_CODE");

        //判断实体是否为空

        if (serverCode.equalsIgnoreCase(securityCode)) {

            if (null != backUser) {
                //判断账号是否被禁用
                if (5 == backUser.getStateid()) {
                    //判断账号是否已被删除
                    if (0 == backUser.getIsdeleted()) {
                        if (9 == backUser.getRoleid()) {
                            remsg = "adminsucc";
                            request.getSession().setAttribute("backUser", backUser);
                        } else {
                            remsg = "tollsucc";
                            request.getSession().setAttribute("backUser", backUser);
                        }
                    } else {
                        remsg = "Non-exist";
                    }
                } else {
                    remsg = "Prohibit";
                }
            }
        } else {
            remsg = "codefail";
        }
        return remsg;
    }


    @Log(operationType = "检测用户名", operationName = "判断用户名是否存在或是否禁用", module = "系统管理")
    @RequestMapping(value = "/CheckName.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public @ResponseBody
    Map<String, String> CheckName(HttpServletRequest request, String userid) {

        Map<String, String> map = new HashMap<String, String>();
        System.out.println(userid + "++");
        TblBackUser user = userBiz.CheckName(userid);

        if (null == user) {
            map.put("info", "userfail");
        } else {
            if (5 == user.getStateid()) {
                if (0 == user.getIsdeleted()) {
                    map.put("info", "success");
                } else {
                    map.put("info", "Non-exist");
                }
            } else {
                map.put("info", "Prohibit");
            }
        }


        return map;
    }


}
