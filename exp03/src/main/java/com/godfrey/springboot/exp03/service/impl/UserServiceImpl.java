package com.godfrey.springboot.exp03.service.impl;

import com.godfrey.springboot.exp03.dao.UserDao;
import com.godfrey.springboot.exp03.entity.User;
import com.godfrey.springboot.exp03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * description : 服务类实现类
 *
 * @author godfrey
 * @since 2020-04-18
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao = null;

    /**
     * description : 插入数据
     *
     * @param user 1
     * @return : com.godfrey.springboot.exp03.pojo.User
     * @author : godfrey
     * @since : 2020/4/19 11:44
     */
    @Override
    public User insertUser(User user) {
        return userDao.insertUser(user) > 0 ? user : null;
    }

    /**
     * description : 获取用户数据
     *
     * @param id 1
     * @return : com.godfrey.springboot.exp03.pojo.User
     * @author : godfrey
     * @since : 2020/4/19 11:45
     */
    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    /**
     * description : 根据条件查找用户
     *
     * @param userName 1
     * @param note     2
     * @param start    3
     * @param limit    4
     * @return : java.util.List<com.godfrey.springboot.exp03.pojo.User>
     * @author : godfrey
     * @since : 2020/4/19 11:45
     */
    @Override
    public List<User> findUsers(String userName, String note, int start, int limit) {
        return userDao.findUsers(userName, note, start, limit);
    }

    /**
     * description : 更新用户数据
     *
     * @param user 1
     * @return : int
     * @author : godfrey
     * @since : 2020/4/19 11:46
     */
    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    /**
     * description : 更新用户姓名
     *
     * @param id       1
     * @param userName 2
     * @return : int
     * @author : godfrey
     * @since : 2020/4/19 11:46
     */
    @Override
    public int updateUserName(Long id, String userName) {
        return userDao.updateUserName(id, userName);
    }

    /**
     * description : 删除用户
     *
     * @param id 1
     * @return : int
     * @author : godfrey
     * @since : 2020/4/19 11:47
     */
    @Override
    public int deleteUser(Long id) {
        return userDao.deleteUser(id);
    }
}
