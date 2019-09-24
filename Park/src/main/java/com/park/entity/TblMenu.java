package com.park.entity;

/**
 * @Date: 2019/9/19 14:06
 * @Description: 菜单表
 */


public class TblMenu {
    private Integer mid;//子级ID
    private String menuname;//菜单名字
    private Integer pid;//父级ID
    private Integer roleid;//角色id

    public TblMenu() {
    }

    public TblMenu(Integer mid, String menuname, Integer pid, Integer roleid) {
        this.mid = mid;
        this.menuname = menuname;
        this.pid = pid;
        this.roleid = roleid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
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
