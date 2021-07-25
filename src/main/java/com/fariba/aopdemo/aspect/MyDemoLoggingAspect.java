package com.fariba.aopdemo.aspect;

import com.fariba.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(-1)
public class MyDemoLoggingAspect {

    @AfterThrowing(pointcut = "execution(* com.fariba.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint,Throwable exc){
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
}
