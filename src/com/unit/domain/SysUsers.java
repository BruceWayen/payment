package com.unit.domain;

public class SysUsers
{
    private Long id;

    private Long contractNo;

    private String userName;

    private String sex;

    private String loginNo;

    private String passWord;

    private String idIccid;

    private String deptId;

    private String phoneNo;

    private String userSatus;

    private String registerTime;

    private String registerType;

    private String roleId;

    private String lastLoginTime;
    private String loginTime;

    private String roleName;

    private String deptName;

    private String systemFee;

    private String userFee;
    private String totalFee;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getContractNo()
    {
        return contractNo;
    }

    public void setContractNo(Long contractNo)
    {
        this.contractNo = contractNo;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getLoginNo()
    {
        return loginNo;
    }

    public void setLoginNo(String loginNo)
    {
        this.loginNo = loginNo == null ? null : loginNo.trim();
    }

    public String getPassWord()
    {
        return passWord;
    }

    public void setPassWord(String passWord)
    {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getIdIccid()
    {
        return idIccid;
    }

    public void setIdIccid(String idIccid)
    {
        this.idIccid = idIccid == null ? null : idIccid.trim();
    }

    public String getDeptId()
    {
        return deptId;
    }

    public void setDeptId(String deptId)
    {
        this.deptId = deptId;
    }

    public String getPhoneNo()
    {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo)
    {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    public String getUserSatus()
    {
        return userSatus;
    }

    public void setUserSatus(String userSatus)
    {
        this.userSatus = userSatus;
    }

    public String getRegisterTime()
    {
        return registerTime;
    }

    public void setRegisterTime(String registerTime)
    {
        this.registerTime = registerTime;
    }

    public String getRegisterType()
    {
        return registerType;
    }

    public void setRegisterType(String registerType)
    {
        this.registerType = registerType;
    }

    public String getRoleId()
    {
        return roleId;
    }

    public void setRoleId(String roleId)
    {
        this.roleId = roleId;
    }

    public String getLastLoginTime()
    {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime)
    {
        this.lastLoginTime = lastLoginTime;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    public String getDeptName()
    {
        return deptName;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
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

    public String getTotalFee()
    {
        return totalFee;
    }

    public void setTotalFee(String totalFee)
    {
        this.totalFee = totalFee;
    }

    public String getLoginTime()
    {
        return loginTime;
    }

    public void setLoginTime(String loginTime)
    {
        this.loginTime = loginTime;
    }
}