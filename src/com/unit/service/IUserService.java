package com.unit.service;

import com.unit.domain.SysUsers;

import java.util.List;
import java.util.Map;

/**
 * @DESCRIPTION ${END}
 * @AUTHOR SongHongWei
 * @TIME 2018/5/9-15:20
 * @PACKAGE_NAME main.java.com.unit.payment
 **/
public interface IUserService
{
    public List<SysUsers> getAll();

    public SysUsers getUser(SysUsers user);

    public int delete(int id);

    public int update(SysUsers user);

    public int add(SysUsers user);

    public List<SysUsers> find(Map<String, Object> map);

    public Long getTotal(Map<String, Object> map);

    public SysUsers getUserById(int id);
}