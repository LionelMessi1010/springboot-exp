package com.godfrey.springboot.exp02.service.impl;

import com.godfrey.springboot.exp02.entity.User;
import com.godfrey.springboot.exp02.mapper.UserMapper;
import com.godfrey.springboot.exp02.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author godfrey
 * @since 2020-04-12
 *
 * 服务类实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
