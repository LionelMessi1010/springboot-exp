package com.godfrey.springboot.exp03.main;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description : 启动类
 *
 * @author godfrey
 * @since 2020-04-18
 */
@SpringBootApplication(scanBasePackages = "com.godfrey.springboot.exp03")
@MapperScan(basePackages = "com.godfrey.springboot.exp03", annotationClass = Mapper.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
