package com.generalnitin.springaop.services;

import com.generalnitin.springaop.aspects.CustomAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HomeService {

    @CustomAnnotation(metricName = "service")
    public String sayHello() {
        return "Hello World!";
    }
}
