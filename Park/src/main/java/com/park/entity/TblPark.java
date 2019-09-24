package com.park.entity;

/**
 * @Date: 2019/9/19 14:06
 * @Description: 车辆停车表
 */

public class TblPark {
    private Integer parkid;//车位号
    private String carid;//车牌号

    public TblPark() {
    }

    public Integer getParkid() {
        return parkid;
    }

    public void setParkid(Integer parkid) {
        this.parkid = parkid;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }
}
