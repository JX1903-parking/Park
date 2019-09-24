package com.park.mapper;

import com.park.entity.TblUser;
import com.park.entity.TblUserList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    /**
     * 功能描述:获取列表总数
     *
     * @param: userList
     * @return: Integer
     * @auther: hua
     * @date: 2019/9/20 22:31
     */

    public Integer getUserCount(TblUserList userList);

    /**
     * 功能描述:查询前台用户列表
     *
     * @param: userList
     * @return: List
     * @auther: hua
     * @date: 2019/9/20 22:31
     */

    public List<TblUser> findByUser(TblUserList userList);



    /**
     * 功能描述:修改账号状态
     *
     * @param: state
     * @param: userid
     * @return: Integer
     * @auther: hua
     * @date: 2019/9/20 22:31
     */

    public Integer UpdateUserStatus(@Param("state") Integer state, @Param("userid") String userid);
    public TblUser findUserById(@Param("userid") String userid);
    public int updateUser(TblUser user);
}
