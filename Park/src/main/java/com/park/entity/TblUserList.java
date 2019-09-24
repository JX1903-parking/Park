package com.park.entity;

/**
 * @Auther: 林深时见鹿
 * @Date: 2019/9/16 04:39
 * @Description:
 */
public class TblUserList {
    private Integer page;
    private Integer limit;
    private String starttime;
    private String endtime;
    private String username;

    public TblUserList(Integer page, Integer limit, String starttime, String endtime, String username) {
        this.page = page;
        this.limit = limit;
        this.starttime = starttime;
        this.endtime = endtime;
        this.username = username;
    }

    public TblUserList() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
