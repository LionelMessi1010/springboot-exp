package com.godfrey.springboot.exp03.service;

import com.godfrey.springboot.exp03.entity.User;

import java.util.List;

/**
 * description : 服务类
 *
 * @author godfrey
 * @since 2020-04-18
 */
public interface UserService {

    /**
     * description : 插入数据
     *
     * @param user 1
     * @return : com.godfrey.springboot.exp03.pojo.User
     * @author : godfrey
     * @since : 2020/4/19 11:44
     */
    public User insertUser(User user);

    /**
     * description : 获取用户数据
     *
     * @param id 1
     * @return : com.godfrey.springboot.exp03.pojo.User
     * @author : godfrey
     * @since : 2020/4/19 11:45
     */
    public User getUser(Long id);

    /**
     * description : 根据条件查找用户
     *
     * @param userName 1
     * @param note 2
     * @param start 3
     * @param limit 4
     * @return : java.util.List<com.godfrey.springboot.exp03.pojo.User>
     * @author : godfrey
     * @since : 2020/4/19 11:45
     */
    public List<User> findUsers(String userName, String note, int start, int limit);

    /**
     * description : 更新用户数据
     *
     * @param user 1
     * @return : int
     * @author : godfrey
     * @since : 2020/4/19 11:46
     */
    public int updateUser(User user);

    /**
     * description : 更新用户姓名
     *
     * @param id 1
     * @param userName 2
     * @return : int
     * @author : godfrey
     * @since : 2020/4/19 11:46
     */
    public int  updateUserName(Long id, String userName);

    /**
     * description : 删除用户
     *
     * @param id 1
     * @return : int
     * @author : godfrey
     * @since : 2020/4/19 11:47
     */
    public int deleteUser(Long id);
}
