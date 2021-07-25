package com.fariba.aopdemo;

import com.fariba.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerMainAopDemo {

    private static Logger logger = Logger.getLogger(AroundWithLoggerMainAopDemo.class.getName());

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        logger.info("\nmain Program: AroundDemoApp");
        logger.info("\nmain Program : calling getFortune");
        String data = trafficFortuneService.getFortune();
        logger.info("\nmy fortunc is: " + data);
        logger.info("\nFinished!!");
        context.close();
    }
}
