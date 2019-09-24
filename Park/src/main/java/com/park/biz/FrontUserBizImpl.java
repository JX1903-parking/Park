package com.park.biz;

import com.park.entity.TblUser;
import com.park.entity.TblUserList;
import com.park.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("frontUserBiz")
public class FrontUserBizImpl implements FrontUserBiz {
    @Resource
    private UserMapper userMapper;

    @Override
    public Integer getUserCount(TblUserList userList) {
        return userMapper.getUserCount(userList);
    }

    @Override
    public List<TblUser> findByUser(TblUserList userList) {
        return userMapper.findByUser(userList);

    }


    @Override
    public Integer UpdateUserStatus(Integer state, String userid) {

        return userMapper.UpdateUserStatus(state, userid);
    }

    @Override
    public TblUser findUserById(String userid) {
        return userMapper.findUserById(userid);
    }

    @Override
    public int updateUser(TblUser user) {
        return userMapper.updateUser(user);
    }

}
