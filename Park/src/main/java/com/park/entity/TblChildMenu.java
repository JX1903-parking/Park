package com.park.entity;

/**
 * @Auther: 林深时见鹿
 * @Date: 2019/9/24 10:02
 * @Description: 子级菜单表
 */
public class TblChildMenu {

    private Integer cid;
    private String cname;
    private String cpath;
    private Integer pid;
    private Integer cstateid;//是否删除id

    public TblChildMenu() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCpath() {
        return cpath;
    }

    public void setCpath(String cpath) {
        this.cpath = cpath;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCstateid() {
        return cstateid;
    }

    public void setCstateid(Integer cstateid) {
        this.cstateid = cstateid;
    }
}
