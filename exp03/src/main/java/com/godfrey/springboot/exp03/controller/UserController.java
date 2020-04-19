package com.godfrey.springboot.exp03.controller;

import com.godfrey.springboot.exp03.entity.enumeration.SexEnum;
import com.godfrey.springboot.exp03.entity.User;
import com.godfrey.springboot.exp03.service.UserService;
import com.godfrey.springboot.exp03.vo.UserVo;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * description : 前端控制器
 *
 * @author godfrey
 * @since 2020-04-18
 */
@Controller
public class UserController {

    /**
     * 用户服务接口
     */
    @Autowired
    private UserService userService = null;

    /**
     * description : 首页
     *
     * @return : java.lang.String
     * @author : godfrey
     * @since : 2020/4/19 12:36
     */
    @GetMapping("/restful")
    public String index() {
        return "restful";
    }

    /**
     * description : 插入数据
     *
     * @param userVo 1
     * @return : com.godfrey.springboot.exp03.pojo.User
     * @author : godfrey
     * @since : 2020/4/19 12:41
     */
    @PostMapping("/user")
    @ResponseBody
    public User insertUser(@RequestBody UserVo userVo) {
        User user = this.changeToPo(userVo);
        return userService.insertUser(user);
    }

    /**
     * description : 获取用户
     *
     * @param id 1
     * @return : com.godfrey.springboot.exp03.vo.UserVo
     * @author : godfrey
     * @since : 2020/4/19 12:48
     */
    @GetMapping("/user/{id}")
    @ResponseBody
    public UserVo getUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        return changeToVo(user);
    }

    /**
     * description : 根据条件查询用户并返回
     *
     * @param userName 1
     * @param note     2
     * @param start    3
     * @param limit    4
     * @return : java.util.List<com.godfrey.springboot.exp03.vo.UserVo>
     * @author : godfrey
     * @since : 2020/4/19 12:52
     */
    @GetMapping("/users/{userName}/{note}/{start}/{limit}")
    @ResponseBody
    public List<UserVo> findUsers(@PathVariable("name") String userName, @PathVariable("note") String note, @PathVariable("start") int start, @PathVariable("limit") int limit) {
        List<User> userList = userService.findUsers(userName, note, start, limit);
        return this.changeToVoes(userList);
    }

    /**
     * description : 更新用户数据
     *
     * @param id     1
     * @param userVo 2
     * @return : com.godfrey.springboot.exp03.pojo.User
     * @author : godfrey
     * @since : 2020/4/19 12:53
     */
    @PutMapping("/user/{id}")
    @ResponseBody
    public User updateUser(@PathVariable("id") Long id, @RequestBody UserVo userVo) {
        User user = this.changeToPo(userVo);
        user.setId(id);
        userService.updateUser(user);
        return user;
    }

    /**
     * description : 修改用户姓名
     *
     * @param id       1
     * @param userName 2
     * @return : ResultVo
     * @author : godfrey
     * @since : 2020/4/19 12:54
     */
    @PatchMapping("/user/{id}/{userName}")
    @ResponseBody
    public ResultVo changeUserName(@PathVariable("id") Long id, @PathVariable("userName") String userName) {
        int result = userService.updateUserName(id, userName);
        return new ResultVo(result > 0, result > 0 ? "更新成功" : "更新用户【" + id + "】失败。");
    }

    /**
     * description : 删除用户
     *
     * @param id 1
     * @return : ResultVo
     * @author : godfrey
     * @since : 2020/4/19 12:54
     */
    @DeleteMapping("/user/{id}")
    @ResponseBody
    public ResultVo deleteUser(@PathVariable("id") Long id) {
        int result = userService.deleteUser(id);
        return new ResultVo(result > 0, result > 0 ? "更新成功" : "更新用户【" + id + "】失败。");
    }

    /**
     * description : 修改用户名方法2
     *
     * @param id       1
     * @param userName 2
     * @return : ResultVo
     * @author : godfrey
     * @since : 2020/4/19 12:55
     */
    @PatchMapping("/user/name")
    @ResponseBody
    public ResultVo changeUserName2(Long id, String userName) {
        int result = userService.updateUserName(id, userName);
        return new ResultVo(result > 0, result > 0 ? "更新成功" : "更新用户名【" + id + "】失败。");
    }

    /**
     * description : 映射JSP视图
     *
     * @return : java.lang.String
     * @author : godfrey
     * @since : 2020/4/19 12:56
     */
    @GetMapping("/user/name")
    public String changeUserName() {
        return "change_user_name";
    }

    /**
     * description : 响应200状态码
     *
     * @param id 1
     * @return : com.godfrey.springboot.exp03.vo.UserVo
     * @author : godfrey
     * @since : 2020/4/19 12:57
     */
    @GetMapping(value = "/user/exp/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public UserVo getUserForExp(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        // 如果找不到用户，则抛出异常，进入控制器通知
        if (user == null) {
            try {
                throw new NotFoundException("找不到用户【" + id + "】信息");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        assert user != null;
        return changeToVo(user);
    }


    /*
     * description : 转换Vo变为PO
     *
     * @param userVo 1
     * @return : com.godfrey.springboot.exp03.pojo.User
     * @author : godfrey
     * @since : 2020/4/19 13:03
     */
    private User changeToPo(UserVo userVo) {
        User user = new User();
        user.setId(userVo.getId());
        user.setUserName(userVo.getUserName());
        user.setSex(SexEnum.getSexEnum(userVo.getSexCode()));
        user.setNote(userVo.getNote());
        return user;
    }

    /**
     * description : 转换PO变为VO
     *
     * @param user 1
     * @return : com.godfrey.springboot.exp03.vo.UserVo
     * @author : godfrey
     * @since : 2020/4/19 13:04
     */
    private UserVo changeToVo(User user) {
        UserVo userVo = new UserVo();
        userVo.setId(user.getId());
        userVo.setUserName(user.getUserName());
        userVo.setSexCode(user.getSex().getCode());
        userVo.setSexName(user.getSex().getName());
        userVo.setNote(user.getNote());
        return userVo;
    }

    /**
     * description : 将PO列表转换为VO列表
     *
     * @param poList 1
     * @return : java.util.List<com.godfrey.springboot.exp03.vo.UserVo>
     * @author : godfrey
     * @since : 2020/4/19 13:04
     */
    private List<UserVo> changeToVoes(List<User> poList) {
        List<UserVo> voList = new ArrayList<>();
        for (User user : poList) {
            UserVo userVo = changeToVo(user);
            voList.add(userVo);
        }
        return voList;
    }


    /**
     * description : 结果VO类
     *
     * @author : godfrey
     * @since : 2020/4/19 13:05
     */
    public static class ResultVo {

        private Boolean success = null;
        private String message = null;

        public ResultVo() {
        }

        public ResultVo(Boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }
}
