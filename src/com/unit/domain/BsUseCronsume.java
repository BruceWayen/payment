package com.unit.domain;

import java.util.Date;

public class BsUseCronsume {
    private Long id;

    private Integer contractNo;

    private Integer busiNo;

    private String consumeDesc;

    private Integer price;

    private String loginAccept;

    private Date opTime;

    private Integer foodId;

    private String opNote;

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

    public Integer getBusiNo() {
        return busiNo;
    }

    public void setBusiNo(Integer busiNo) {
        this.busiNo = busiNo;
    }

    public String getConsumeDesc() {
        return consumeDesc;
    }

    public void setConsumeDesc(String consumeDesc) {
        this.consumeDesc = consumeDesc == null ? null : consumeDesc.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(String loginAccept) {
        this.loginAccept = loginAccept == null ? null : loginAccept.trim();
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getOpNote() {
        return opNote;
    }

    public void setOpNote(String opNote) {
        this.opNote = opNote == null ? null : opNote.trim();
    }
}