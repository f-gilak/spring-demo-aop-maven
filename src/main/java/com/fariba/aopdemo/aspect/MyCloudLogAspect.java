package com.fariba.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-7)
public class MyCloudLogAspect {

    @Before("com.fariba.aopdemo.aspect.CommonAopExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("\n======>>> Logging to cloud inasync fashion");
    }
}
