package com.park.entity;

/**
 * @Date: 2019/9/19 14:06
 * @Description: 车辆信息表
 */

public class TblCar {
    private String carid;//车牌号
    private String begintime;//开始时间
    private String endtime;//到期时间
    private String carimage;//车子图片
    private Integer locationid;//车位
    private TblRight right;//车辆权限表
    private TblUser user;//用户表

    public TblCar() {
    }

    public TblCar(String carid, String begintime, String endtime, String carimage, Integer locationid, TblRight right, TblUser user) {
        this.carid = carid;
        this.begintime = begintime;
        this.endtime = endtime;
        this.carimage = carimage;
        this.locationid = locationid;
        this.right = right;
        this.user = user;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getCarimage() {
        return carimage;
    }

    public void setCarimage(String carimage) {
        this.carimage = carimage;
    }

    public TblRight getRight() {
        return right;
    }

    public void setRight(TblRight right) {
        this.right = right;
    }

    public TblUser getUser() {
        return user;
    }

    public void setUser(TblUser user) {
        this.user = user;
    }

    public Integer getLocationid() {
        return locationid;
    }

    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }
}
