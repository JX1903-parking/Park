package com.park.biz;

import com.park.entity.TblBackUser;
import com.park.mapper.BackUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("userBiz")
public class UserBizImpl implements UserBiz {
    @Resource
    private BackUserMapper backUserMapper;

    /**
     * @deprecated : 后台用户登录
     * @param userid 用户名
     * @param upass  密码
     * @return
     */
    @Override
    public TblBackUser backLogin(String userid,String upass) {
        TblBackUser backUser = backUserMapper.backLogin(userid,upass);
        return backUser;
    }

    /**
     * @deprecated : 删除收费员
     * @param userid 用户名
     * @return
     */
    @Override
    public int delBackUser(String userid) {
        int num = backUserMapper.delBackUser(userid);
        return num;
    }

    @Override
    public List<TblBackUser> findAllBackUser(Map<String, Object> paramap) {
        System.out.println(paramap.get("begintime")+" "+paramap.get("limit"));
        List<TblBackUser> backUserList = backUserMapper.findAllBackUser(paramap);
        return backUserList;
    }

    @Override
    public int getCount(Map<String,Object> findMap) {
        int count = backUserMapper.getCount(findMap);
        return count;
    }

    @Override
    public int updateBackUserParam(String userid, int paramid) {
        int num = backUserMapper.updateBackUserParam(userid,paramid);
        return num;
    }

    @Override
    public TblBackUser findBackUserById(String userid) {
        TblBackUser backUser = backUserMapper.findBackUserById(userid);
        return backUser;
    }

    @Override
    public int freshBackUser(TblBackUser backUser,String title) {
        int num = 0;
        System.out.println("进入bizImpl"+title);
        if (title.equals("新增用户")) {
            System.out.println("进入新增");
            num = backUserMapper.addBackUser(backUser);
        }else {
            num = backUserMapper.updateBackUser(backUser);
        }
        return num;
    }

    @Override
    public List<String> findParentMenu(int roleid) {
        List<String> pMenuList = backUserMapper.findParentMenu(roleid);
        return pMenuList;
    }
}
