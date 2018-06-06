package com.unit.service.impl;

import com.unit.dao.SysUsersMapper;
import com.unit.domain.SysUsers;
import com.unit.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @DESCRIPTION ${END}
 * @AUTHOR SongHongWei
 * @TIME 2018/5/9-15:21
 * @PACKAGE_NAME main.java.com.unit.payment.service.impl
 **/
@Service(value = "userService")
public class UserServiceImpl implements IUserService
{
    private SysUsersMapper userDao;

    @Resource
    public void setUserDao(SysUsersMapper userDao)
    {
        this.userDao = userDao;
    }

    @Override
    public List<SysUsers> getAll()
    {
        return null;
    }

    @Override
    public SysUsers getUser(SysUsers user)
    {
        return null;
    }

    @Override
    public int delete(int id)
    {
        return 0;
    }

    @Override
    public int update(SysUsers user)
    {
        return 0;
    }

    @Override
    public int add(SysUsers user)
    {
        return 0;
    }

    @Override
    public List<SysUsers> find(Map<String, Object> map)
    {
        return null;
    }

    @Override
    public Long getTotal(Map<String, Object> map)
    {
        return null;
    }

    @Override
    public SysUsers getUserById(int id)
    {
        return null;
    }
}
