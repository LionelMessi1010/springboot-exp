package com.godfrey.springboot.exp02.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author godfrey
 * @since 2020-04-12
 */
@Configuration
@MapperScan("com.godfrey.springboot.exp01.mapper")
public class UserConfig {
}
