package com.park.entity;

/**
 * @Date: 2019/9/19 14:06
 * @Description: 菜单过渡表
 */


public class TblTransitionMenu {
    private Integer cid;
    private Integer pid;
    private Integer roleid;

    public TblTransitionMenu(Integer cid, Integer pid, Integer roleid) {
        this.cid = cid;
        this.pid = pid;
        this.roleid = roleid;
    }

    public TblTransitionMenu() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}
