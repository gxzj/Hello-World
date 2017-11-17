package com.gx.po;

public class Power {
    /**
    * 权限
    */
    private Integer powerid;

    /**
    * 用户
    */
    private Integer userid;

    /**
    * 权限名
    */
    private String powername;

    public Integer getPowerid() {
        return powerid;
    }

    public void setPowerid(Integer powerid) {
        this.powerid = powerid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPowername() {
        return powername;
    }

    public void setPowername(String powername) {
        this.powername = powername;
    }
}