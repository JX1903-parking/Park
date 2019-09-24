package com.park.entity;

/**
 * @Date: 2019/9/19 14:06
 * @Description: 日志表
 */

public class TblLog {
    private Integer logid;
    private String userid;
    private String backuserid;
    private String incident;//事件
    private String acttime;//时间
    private String uname;//用户名字
    private TblBackUser backUser;

    public TblLog() {
    }

    public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBackuserid() {
        return backuserid;
    }

    public void setBackuserid(String backuserid) {
        this.backuserid = backuserid;
    }

    public String getIncident() {
        return incident;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }

    public String getActtime() {
        return acttime;
    }

    public void setActtime(String acttime) {
        this.acttime = acttime;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public TblBackUser getBackUser() {
        return backUser;
    }

    public void setBackUser(TblBackUser backUser) {
        this.backUser = backUser;
    }
}
