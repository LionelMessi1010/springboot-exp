package com.godfrey.springboot.exp02.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author godfrey
 * @since 2020-04-12
 *
 * 配置类
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.godfrey.springboot.exp02.mapper")
public class MybatisPlusConfig {
    /**
     * 配置分页插件
     *
     * @return PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
