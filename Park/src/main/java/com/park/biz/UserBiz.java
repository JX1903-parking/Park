package com.park.biz;

import com.park.entity.TblBackUser;

import java.util.List;
import java.util.Map;

public interface UserBiz {
    public TblBackUser backLogin(String userid, String upass);
    public TblBackUser CheckName(String userid);
    public int delBackUser(String userid);
    public List<TblBackUser> findAllBackUser(Map<String, Object> paramap);
    public int getCount(Map<String, Object> findMap);
    public int updateBackUserParam(String userid, int paramid);
    public TblBackUser findBackUserById(String userid);
    public int freshBackUser(TblBackUser backUser, String title);
    public List<String> findParentMenu(int roleid);
}
