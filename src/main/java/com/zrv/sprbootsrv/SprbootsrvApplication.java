package com.zrv.sprbootsrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.zrv.sprbootsrv.dto"})
public class SprbootsrvApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprbootsrvApplication.class, args);
    }

}
