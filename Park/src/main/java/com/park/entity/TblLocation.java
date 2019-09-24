package com.park.entity;

/**
 * @Date: 2019/9/19 14:06
 * @Description: 车位表
 */
public class TblLocation {
    private Integer locationid;//车位id
    private String locationstateid;//车位状态
    private TblParam param;//参数表

    public TblLocation() {
    }

    public Integer getLocationid() {
        return locationid;
    }

    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }

    public String getLocationstateid() {
        return locationstateid;
    }

    public void setLocationstateid(String locationstateid) {
        this.locationstateid = locationstateid;
    }

    public TblParam getParam() {
        return param;
    }

    public void setParam(TblParam param) {
        this.param = param;
    }
}
