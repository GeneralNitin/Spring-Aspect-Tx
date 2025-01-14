package com.generalnitin.springaop;

import com.generalnitin.springaop.services.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
public class SpringAopApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringAopApplication.class);

    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = SpringApplication.run(SpringAopApplication.class, args)) {
            System.out.println(context.getBean(HomeService.class).sayHello());
            System.out.println(context.getBean(HomeService.class).testTransaction());
        }
    }
}
