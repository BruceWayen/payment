package main.java.com.unit.service.impl;

import main.java.com.unit.domain.User;
import main.java.com.unit.dao.UserDao;
import main.java.com.unit.service.IUserService;
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
    private UserDao userDao;

    @Resource
    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAll()
    {
        return userDao.getAll();
    }

    @Override
    public User getUser(User user)
    {
        return userDao.getUser(user);
    }

    @Override
    public int delete(int id)
    {
        return userDao.delete(id);
    }

    @Override
    public int update(User user)
    {
        return userDao.update(user);
    }

    @Override
    public int add(User user)
    {
        return userDao.add(user);
    }

    @Override
    public List<User> find(Map<String, Object> map)
    {
        return userDao.find(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map)
    {
        return userDao.getTotal(map);
    }

    public User getUserById(int id)
    {
        return userDao.getUserById(id);
    }
}
