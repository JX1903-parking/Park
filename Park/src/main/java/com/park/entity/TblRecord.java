package com.park.entity;

/**
 * @Date: 2019/9/19 14:06
 * @Description: 车辆进出记录表
 */

public class TblRecord {
    private Integer recordid;//流水ID
    private String carid;//车牌号
    private String intime;//进入时间
    private String outtime;//出去时间
    private String clerkid;//收费员ID
    private Integer charge;//收费金额
    private Integer locationid;//车位号
    private TblBackUser backUser;//后台用户实体

    public TblRecord() {
    }

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(String intime) {
        this.intime = intime;
    }

    public String getOuttime() {
        return outtime;
    }

    public void setOuttime(String outtime) {
        this.outtime = outtime;
    }

    public String getClerkid() {
        return clerkid;
    }

    public void setClerkid(String clerkid) {
        this.clerkid = clerkid;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    public Integer getLocationid() {
        return locationid;
    }

    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }

    public TblBackUser getBackUser() {
        return backUser;
    }

    public void setBackUser(TblBackUser backUser) {
        this.backUser = backUser;
    }
}
