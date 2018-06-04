package com.unit.domain;

import java.util.Date;

public class SysContractInfo {
    private Long id;

    private Integer userId;

    private String contractName;

    private Integer contractStatus;

    private String contractPasswd;

    private Integer systemFee;

    private Integer userFee;

    private Date payTime;

    private String payAccept;

    private Integer payType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    public Integer getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(Integer contractStatus) {
        this.contractStatus = contractStatus;
    }

    public String getContractPasswd() {
        return contractPasswd;
    }

    public void setContractPasswd(String contractPasswd) {
        this.contractPasswd = contractPasswd == null ? null : contractPasswd.trim();
    }

    public Integer getSystemFee() {
        return systemFee;
    }

    public void setSystemFee(Integer systemFee) {
        this.systemFee = systemFee;
    }

    public Integer getUserFee() {
        return userFee;
    }

    public void setUserFee(Integer userFee) {
        this.userFee = userFee;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPayAccept() {
        return payAccept;
    }

    public void setPayAccept(String payAccept) {
        this.payAccept = payAccept == null ? null : payAccept.trim();
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }
}