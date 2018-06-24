package com.unit.domain;

public class SysContractInfo {
    private Long id;

    private String userId;

    private String contractName;

    private String contractStatus;

    private String contractPasswd;

    private String systemFee;

    private String userFee;

    private String payTime;

    private String payAccept;

    private String payType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getContractName()
    {

        return contractName;
    }

    public void setContractName(String contractName)
    {
        this.contractName = contractName;
    }

    public String getContractStatus()
    {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus)
    {
        this.contractStatus = contractStatus;
    }

    public String getContractPasswd()
    {
        return contractPasswd;
    }

    public void setContractPasswd(String contractPasswd)
    {
        this.contractPasswd = contractPasswd;
    }

    public String getSystemFee()
    {
        return systemFee;
    }

    public void setSystemFee(String systemFee)
    {
        this.systemFee = systemFee;
    }

    public String getUserFee()
    {
        return userFee;
    }

    public void setUserFee(String userFee)
    {
        this.userFee = userFee;
    }

    public String getPayTime()
    {
        return payTime;
    }

    public void setPayTime(String payTime)
    {
        this.payTime = payTime;
    }

    public String getPayAccept()
    {
        return payAccept;
    }

    public void setPayAccept(String payAccept)
    {
        this.payAccept = payAccept;
    }

    public String getPayType()
    {
        return payType;
    }

    public void setPayType(String payType)
    {
        this.payType = payType;
    }
}