package com.park.mapper;

import com.park.entity.TblBackUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BackUserMapper {

    /**
     * @deprecated  后台用户登录
     * @param userid
     * @param upass
     * @return
     */
    public TblBackUser backLogin(@Param("userid") String userid, @Param("upass") String upass);

    /**
     * @deprecated  删除后台用户
     * @param userid
     * @return
     */
    public int delBackUser(@Param("userid") String userid);

    public List<TblBackUser> findAllBackUser(Map<String, Object> paramap);

    public int getCount(Map<String, Object> findMap);

    public int updateAdmStatus();

    public int updateBackUserParam(@Param("userid") String userid, @Param("paramid") int paramid);

    public TblBackUser findBackUserById(@Param("userid") String userid);

    public int addBackUser(TblBackUser backUser);
    public int updateBackUser(TblBackUser backUser);
    public List<String> findParentMenu(@Param("roleid") int roleid);
}
