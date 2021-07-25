package com.fariba.aopdemo;

import com.fariba.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundMainAopDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        System.out.println("\nmain Program: AroundDemoApp");
        System.out.println("\nmain Program : calling getFortune");
        String data = trafficFortuneService.getFortune();
        System.out.println("\nmy fortunc is: " + data);
        System.out.println("\nFinished!!");
        context.close();
    }
}
