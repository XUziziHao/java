package com.atxzh.reggie;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ServletComponentScan
@Slf4j
@SpringBootApplication

@EnableTransactionManagement//事务控制注解
public class ReggieTest {
    public static void main(String[] args) {
        SpringApplication.run(ReggieTest.class,args);
        log.info("项目启动成功");
    }
}
