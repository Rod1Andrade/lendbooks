package com.github.rod1andrade.lendbookbackend;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class LendbookBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LendbookBackendApplication.class, args);
    }

}
