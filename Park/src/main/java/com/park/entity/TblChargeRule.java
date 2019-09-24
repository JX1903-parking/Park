package com.park.entity;

/**
 * @Date: 2019/9/19 14:06
 * @Description: 车辆信息表
 */

public class TblChargeRule {
    private Integer ruleid;//规则流水号
    private String rulename;//规则名
    private Integer charge;//规章所收费用

    public TblChargeRule() {
    }

    public Integer getRuleid() {
        return ruleid;
    }

    public void setRuleid(Integer ruleid) {
        this.ruleid = ruleid;
    }

    public String getRulename() {
        return rulename;
    }

    public void setRulename(String rulename) {
        this.rulename = rulename;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }
}
