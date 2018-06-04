package main.java.com.unit.dao;

import main.java.com.unit.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @DESCRIPTION ${END}
 * @AUTHOR SongHongWei
 * @TIME 2018/5/9-15:19
 * @PACKAGE_NAME main.java.com.unit.payment
 **/
public interface UserDao {
    /**
     * 用户登录
     * @param user
     * @return
     */
    public User login(User user);
    /**
     * 查询所有用户
     * @return
     */
    public List<User> getAll();
    /**
     * 根据条件查询用户
     * @param user
     * @return
     */
    public User getUser(User user);
    /**
     * 删除用户
     * @param user
     * @return
     */
    public int delete(int id);
    /**
     * 更新用户
     * @param user
     * @return
     */
    public int update(User user);
    /**
     * 添加用户
     * @param user
     * @return
     */
    public int add(User user);
    /**
     * 用户查询
     * @param map
     * @return
     */
    public List<User> find(Map<String,Object> map);
    /**
     * 获取总记录数
     * @param map
     * @return
     */
    public Long getTotal(Map<String,Object> map);
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User getUserById(int id);
}