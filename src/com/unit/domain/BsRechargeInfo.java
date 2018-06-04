package com.unit.domain;

import java.util.Date;

public class BsRechargeInfo {
    private Long id;

    private Integer contractNo;

    private Integer money;

    private Date opTime;

    private String loginAccept;

    private Integer opType;

    private String opNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getContractNo() {
        return contractNo;
    }

    public void setContractNo(Integer contractNo) {
        this.contractNo = contractNo;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public String getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(String loginAccept) {
        this.loginAccept = loginAccept == null ? null : loginAccept.trim();
    }

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    public String getOpNotes() {
        return opNotes;
    }

    public void setOpNotes(String opNotes) {
        this.opNotes = opNotes == null ? null : opNotes.trim();
    }
}