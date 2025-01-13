package com.generalnitin.springaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SpringBootApplication
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
public class SpringAopApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringAopApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringAopApplication.class, args);
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        log.info("init transactionManager");
        return new DataSourceTransactionManager(dataSource);
    }
}