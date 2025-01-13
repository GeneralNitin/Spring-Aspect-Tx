package com.generalnitin.springaop.services;

import com.generalnitin.springaop.aspects.CustomAnnotation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HomeService {

    private final SupportService supportService;

    public HomeService(SupportService supportService) {
        this.supportService = supportService;
    }

    @CustomAnnotation(metricName = "service")
    public String sayHello() {
        return "Hello World!";
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public String testTransaction() {
        supportService.testSupportTransaction();
        return "Success";
    }
}
