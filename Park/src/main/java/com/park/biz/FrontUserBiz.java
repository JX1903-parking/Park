package com.park.biz;

import com.park.entity.TblUser;
import com.park.entity.TblUserList;

import java.util.List;

/**
 * @Auther: 林深时见鹿
 * @Date: 2019/9/20 16:07
 * @Description: 前台用户列表业务处理类
 *
 */
public interface FrontUserBiz {

    /**
     *
     * 功能描述: 获取列表总数
     *
     * @param: userList
     * @return: Integer
     * @auther: hua
     * @date: 2019/9/20 22:18
     */

    public Integer getUserCount(TblUserList userList);

    /**
     *
     * 功能描述: 查询用户列表数据
     *
     * @param: userList
     * @return:  List<TblUser>
     * @auther: hua
     * @date: 2019/9/20 22:19
     */


    public List<TblUser> findByUser(TblUserList userList);



    /**
     *
     * 功能描述: 修改用户账号状态
     *
     * @param: state
     * @param: userid
     * @return: Integer
     * @auther: hua
     * @date: 2019/9/20 22:19
     */



     public Integer UpdateUserStatus(Integer state, String userid);

     public TblUser findUserById(String userid);

     public int updateUser(TblUser user);
}
