package main.java.com.unit.service;

import main.java.com.unit.domain.User;

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
    public List<User> getAll();

    public User getUser(User user);

    public int delete(int id);

    public int update(User user);

    public int add(User user);

    public List<User> find(Map<String, Object> map);

    public Long getTotal(Map<String, Object> map);

    public User getUserById(int id);
}