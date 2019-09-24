package com.park.entity;

/**
 * @Auther: 林深时见鹿
 * @Date: 2019/9/24 10:03
 * @Description: 父级菜单表
 */
public class TblParentMenu {

    private Integer pid;
    private String pname;
    private String purl;
    private Integer ppid;//父级菜单的父级ID
    private Integer pstatusid;

    public TblParentMenu() {
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public Integer getPpid() {
        return ppid;
    }

    public void setPpid(Integer ppid) {
        this.ppid = ppid;
    }

    public Integer getPstatusid() {
        return pstatusid;
    }

    public void setPstatusid(Integer pstatusid) {
        this.pstatusid = pstatusid;
    }
}
