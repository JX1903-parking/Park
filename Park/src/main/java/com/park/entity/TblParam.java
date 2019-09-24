package com.park.entity;

/**
 * @Date: 2019/9/19 14:06
 * @Description: 参数表
 */

public class TblParam {
    private Integer paramid;//参数子级ID
    private String paramname;//参数名
    private Integer pid;//参数父级ID

    public TblParam() {
    }

    public Integer getParamid() {
        return paramid;
    }

    public void setParamid(Integer paramid) {
        this.paramid = paramid;
    }

    public String getParamname() {
        return paramname;
    }

    public void setParamname(String paramname) {
        this.paramname = paramname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
