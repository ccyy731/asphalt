package com.nine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
//@MapperScan("com.nine.mapper")
@SpringBootApplication
public class V2Application {

    public static void main(String[] args) {
        SpringApplication.run(V2Application.class, args);
        log.info("项目启动成功");
    }

}
