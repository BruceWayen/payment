package com.unit.domain;

public class BsRechargeInfo {
    private Long id;

    private String contractNo;

    private String money;

    private String opTime;

    private String loginAccept;

    private String opType;

    private String opNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractNo()
    {
        return contractNo;
    }

    public void setContractNo(String contractNo)
    {
        this.contractNo = contractNo;
    }

    public String getMoney()
    {
        return money;
    }

    public void setMoney(String money)
    {
        this.money = money;
    }

    public String getOpTime()
    {
        return opTime;
    }

    public void setOpTime(String opTime)
    {
        this.opTime = opTime;
    }

    public String getLoginAccept()
    {
        return loginAccept;
    }

    public void setLoginAccept(String loginAccept)
    {
        this.loginAccept = loginAccept;
    }

    public String getOpType()
    {
        return opType;
    }

    public void setOpType(String opType)
    {
        this.opType = opType;
    }

    public String getOpNotes()
    {
        return opNotes;
    }

    public void setOpNotes(String opNotes)
    {
        this.opNotes = opNotes;
    }
}