package com.park.biz;

import com.park.entity.TblCar;
import com.park.entity.TblUser;
import com.park.mapper.WeChatMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("wcBiz")
public class WeChatBizlmpl implements WeChatBiz {
    @Resource
    private WeChatMapper wcMapper;
    @Override
    public TblUser login(String userid, String upass) {
        return wcMapper.login(userid,upass);
    }

    @Override
    public List<TblCar> fendmycar(String userid) { return wcMapper.fendmycar(userid);
    }

    @Override
    public String fendByUserid(String userid) {
        String str="";
        List<TblUser> listuser=wcMapper.fendByUserid(userid);
        if(listuser.size()>0){
            str="该用户名已被注册";
        }else{
            str="ok";
        }
        return str;
    }

    @Override
    public String reg(TblUser user) {
        String str="no";
        int i=wcMapper.reg(user);
        if(i>0){
            str="ok";
        }
        return str;
    }


}
