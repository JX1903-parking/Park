package com.park.program;

import com.park.biz.WeChatBiz;
import com.park.entity.TblCar;
import com.park.entity.TblUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class YbAjaxAction {
    @Resource
    private WeChatBiz wcBiz;

    @RequestMapping(method= RequestMethod.POST,value="/bean2json")
    public @ResponseBody
    TblUser bean2json(TblUser user){
        return user;
    }

//    @RequestMapping(method= RequestMethod.POST,value="/listbean2json")
//    public @ResponseBody
//    List<TblUser> listbean2json(Bean bean){
//        List<TblUser> listuser=bean.getListuser();
//        return listuser;
//    }
//    @RequestMapping(method= RequestMethod.POST,value="/mapbean2json")
//    public @ResponseBody
//    Map<String,Object> mapbean2json(Bean bean){
//        List<TblUser> listuser=bean.getListuser();
//        Map<String, Object> mapuser=new HashMap<String, Object>();
//        mapuser.put("success",true);
//        mapuser.put("detail",listuser);
//        return mapuser;
//    }
    //用户登录
    @RequestMapping(method= RequestMethod.POST,value="/login")
    public @ResponseBody
    TblUser bean2json(@RequestBody Map<String, String> map){
        String userid="";
        String upass="";
        if(map.containsKey("upass")){
            upass=map.get("upass");
        }
        if(map.containsKey("userid")){
            userid=map.get("userid");
        }
        TblUser user=wcBiz.login(userid,upass);
        return user;
    }
    //查询车辆
    @RequestMapping(method= RequestMethod.POST,value="/car")
    public @ResponseBody
    List<TblCar> fendmycar(@RequestBody Map<String, String> map){
        System.out.println("查询我的车车辆");
        List<TblCar>  carlist=null;
        String userid="";
        if(map.containsKey("uid")){
            userid=map.get("uid");
        }
        System.out.println(userid);
        if(!(userid==null||userid.equals(""))){
            carlist=wcBiz.fendmycar(userid);
        }
        return carlist;
    }
    //验证用户ID
    @RequestMapping(method= RequestMethod.POST,value="/userid")
    public @ResponseBody
   String fendByUserid(@RequestBody Map<String, String> map){
        String userid="";
        String str="请输入用户id";
        if(map.containsKey("uid")){
            userid=map.get("uid");
        }
        System.out.println(userid);
        if(!(userid==null||userid.equals(""))){
            str=wcBiz.fendByUserid(userid);
        }
        return str;
    }
    //注册
    @RequestMapping(method= RequestMethod.POST,value="/reg")
    public @ResponseBody
    String Reg(@RequestBody Map<String, String> map){
        TblUser user=new TblUser(map.get("userid"),map.get("uname"),map.get("upass"),map.get("utel"));
        System.out.println(user.getUserid()+"----------"+user.getUname());
        String str="";
        str=wcBiz.reg(user);
        System.out.println(str);
        return str;
    }

}