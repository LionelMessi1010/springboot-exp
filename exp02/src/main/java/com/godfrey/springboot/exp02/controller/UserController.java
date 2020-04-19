package com.godfrey.springboot.exp02.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.godfrey.springboot.exp02.entity.User;
import com.godfrey.springboot.exp02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author godfrey
 * @since 2020-04-12
 *
 * 前端控制器
 */
@Controller
@RequestMapping("/exp02/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 添加
     *
     * @return String
     */
    @RequestMapping("/add")
    public String add(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:list";
    }

    /**
     * 删除
     *
     * @return String
     */
    @RequestMapping("/delete")
    public String delete(Integer id) {
        userService.removeById(id);
        return "redirect:list";
    }

    /**
     * 更新
     *
     * @return String
     */
    @RequestMapping("/update")
    public String update(User user) {
        userService.updateById(user);
        return "redirect:list";
    }

    /**
     * 编辑
     *
     * @return String
     */
    @RequestMapping("/edit")
    public String edit(Model model, Integer id) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    /**
     * 查找
     *
     * @return String
     */
    @RequestMapping("/list")
    public String hello(Model model, @RequestParam(value = "current", required = false, defaultValue = "1") long current) {
        Page<User> curPage = new Page<>();
        curPage.setCurrent(current);
        Page<User> page = userService.page(curPage);
        model.addAttribute("page", page);
        return "list";
    }
}
