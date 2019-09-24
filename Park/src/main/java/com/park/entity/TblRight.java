package com.park.entity;

/**
 * @Date: 2019/9/19 14:06
 * @Description: 车辆权限表
 */

public class TblRight {
    private Integer rightid;//权限id
    private String rightname;//权限名
    private Integer cost;//套餐费用

    public TblRight() {
    }

    public Integer getRightid() {
        return rightid;
    }

    public void setRightid(Integer rightid) {
        this.rightid = rightid;
    }

    public String getRightname() {
        return rightname;
    }

    public void setRightname(String rightname) {
        this.rightname = rightname;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
