package com.unit.domain;

public class SysDept {
    private Integer id;

    private String deptName;

    private String deptAddress;

    private String deptPhone;

    private String deptSuperId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDeptAddress() {
        return deptAddress;
    }

    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress == null ? null : deptAddress.trim();
    }

    public String getDeptPhone() {
        return deptPhone;
    }

    public void setDeptPhone(String deptPhone) {
        this.deptPhone = deptPhone == null ? null : deptPhone.trim();
    }

    public String getDeptSuperId() {
        return deptSuperId;
    }

    public void setDeptSuperId(String deptSuperId) {
        this.deptSuperId = deptSuperId;
    }
}