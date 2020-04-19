package com.godfrey.springboot.exp02.controller;

import com.godfrey.springboot.exp02.entity.User;
import com.godfrey.springboot.exp02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author godfrey
 * @since 2020-04-12
 *
 * 前端控制器
 */
@Controller
@RequestMapping("/exp01/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有数据
     * @return String
     */
    @GetMapping("findAll")
    public String findAll(Model model) {
        List<User> userList = userService.list(null);
        model.addAttribute("userList",userList);
        return "list";
    }
}