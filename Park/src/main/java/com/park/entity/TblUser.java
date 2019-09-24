package com.park.entity;

import java.util.List;

/**
 * @Date: 2019/9/19 14:06
 * @Description: 前台用户表
 */

public class TblUser {
    private String userid;
    private String uname;
    private String upass;
    private String utel;
    private String usex;
    private String uemail;
    private Integer uage;
    private String address;
    private String regtime;
    private Integer stateid;//账号状态
    private Integer isdeleted;//账号是否删除
    private Integer money;//账号余额
    private TblParam param;//参数实体
    private List<TblCar> carList;

    public TblUser() {

    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public Integer getUage() {
        return uage;
    }

    public void setUage(Integer uage) {
        this.uage = uage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public TblParam getParam() {
        return param;
    }

    public void setParam(TblParam param) {
        this.param = param;
    }

    public List<TblCar> getCarList() {
        return carList;
    }

    public void setCarList(List<TblCar> carList) {
        this.carList = carList;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }
}
