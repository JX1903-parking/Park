package com.park.entity;

/**
 * @Date: 2019/9/19 14:06
 * @Description: 用户账户表
 */
public class TblAccount {

    private String userid;//用户账号
    private String carid;//车牌号
    private Integer typeid;//扣费/充值
    private Integer charge;//扣费/充值金额
    private String time;//操作时间
    private TblParam param;//参数实体类


    public TblAccount() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public TblParam getParam() {
        return param;
    }

    public void setParam(TblParam param) {
        this.param = param;
    }
}
