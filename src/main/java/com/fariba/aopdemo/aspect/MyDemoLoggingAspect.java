package com.fariba.aopdemo.aspect;

import com.fariba.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(-1)
public class MyDemoLoggingAspect {

    private static Logger logger = Logger.getLogger(MyDemoLoggingAspect.class.getName());

    @Around("execution(* com.fariba.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n======>>> Executing @Around Advice on method :" + method);
        long begin = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            logger.warning(e.getMessage());
            throw e;
        }
        long end = System.currentTimeMillis();

        long duration = end - begin;
        logger.info("\n=====> duration: " + duration / 1000.0 + " second");

        return result;
    }

    @After("execution(* com.fariba.aopdemo.dao.AccountDAO.findList(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n======>>> Executing @After (finally) Advice on method :" + method);
    }

    @AfterThrowing(pointcut = "execution(* com.fariba.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method:" + method);

        System.out.println("\n=====>>> the Executing is" + exc);
    }

    @AfterReturning(pointcut = "execution(* com.fariba.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method:" + method);
        System.out.println("\n=====>>> Executing @AfterReturning on result is:" + result);
        covertAccountNameToUpperCase(result);

    }

    private void covertAccountNameToUpperCase(List<Account> result) {
        for (Account account : result) {
            String upperCase = account.getName().toUpperCase();
            account.setName(upperCase);
        }
    }

    //    @Before("execution(* com.fariba.aopdemo.dao.*.* (..  ))"
//    @Before("forDaoPackage()")
    @Before("com.fariba.aopdemo.aspect.CommonAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n======>>> Executing Before Advice on addAccount() ");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("account name:" + account.getName());
                System.out.println("account level:" + account.getLevel());
            }
        }
    }
//    @Before("execution(* add* ())")
//    public void beforeAddAccountAdvice() {
//        logger.info("\n======>>> Executing Before Advice on addAccount() ");
//    }
}
