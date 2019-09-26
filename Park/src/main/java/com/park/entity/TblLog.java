package com.park.entity;

import java.io.Serializable;

/**
 * @Date: 2019/9/19 14:06
 * @Description: 日志表
 */

public class TblLog implements Serializable {
    private Integer logid;
    private String uname;//操作用户名字
    private String incident;//事件
    private String module;//执行的模块
    private String acttime;//时间
    private String description;//描述
    private String rsponseDate;//响应时间
    private String ip;//ip地址
    private long endtime;

    public TblLog() {
    }

    public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getIncident() {
        return incident;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getActtime() {
        return acttime;
    }

    public void setActtime(String acttime) {
        this.acttime = acttime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRsponseDate() {
        return rsponseDate;
    }

    public void setRsponseDate(String rsponseDate) {
        this.rsponseDate = rsponseDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getEndtime() {
        return endtime;
    }

    public void setEndtime(long endtime) {
        this.endtime = endtime;
    }
}
