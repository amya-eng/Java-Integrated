package com.zzs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zzs.dao")
public class JavaSpringBootMyBatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringBootMyBatisApplication.class, args);
    }

}
