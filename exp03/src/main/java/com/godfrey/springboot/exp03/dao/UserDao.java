package com.godfrey.springboot.exp03.dao;

import com.godfrey.springboot.exp03.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description : 持久化类
 *
 * @author godfrey
 * @since 2020-04-18
 */
@Mapper
public interface UserDao {

    /**
     * description : 根据id查询User
     *
     * @param id 1
     * @return : com.godfrey.springboot.exp03.pojo.User
     * @author : godfrey
     * @since : 2020/4/18 18:46
     */
    public User getUser(Long id);

    /**
     * description : 插入数据
     *
     * @param user 1
     * @return : int
     * @author : godfrey
     * @since : 2020/4/18 18:46
     */
    public int insertUser(User user);

    /**
     * description : 根据条件查询用户
     *
     * @param userName 1
     * @param note 2
     * @param start 3
     * @param limit 4
     * @return : java.util.List<com.godfrey.springboot.exp03.pojo.User>
     * @author : godfrey
     * @since : 2020/4/18 18:47
     */
    public List<User> findUsers(@Param("userName") String userName, @Param("note") String note, @Param("start") int start, @Param("limit") int limit);

    /**
     * description : 更新用户数据
     *
     * @param user 1
     * @return : int
     * @author : godfrey
     * @since : 2020/4/18 18:48
     */
    public int updateUser(User user);

    /**
     * description : 更新用户名
     *
     * @param id 1
     * @param userName 2
     * @return : int
     * @author : godfrey
     * @since : 2020/4/18 18:48
     */
    public int updateUserName(@Param("id") Long id, @Param("userName") String userName);

    /**
     * description : 根据id删除用户
     *
     * @param id 1
     * @return : int
     * @author : godfrey
     * @since : 2020/4/18 18:49
     */
    public int deleteUser(Long id);
}