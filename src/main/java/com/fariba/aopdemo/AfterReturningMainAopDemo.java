package com.fariba.aopdemo;

import com.fariba.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningMainAopDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = accountDAO.findAccounts(false);
        System.out.println("\n\nMain program: AfterReturningDemoApp");
        System.out.println("---");
        System.out.println(accounts);
        System.out.println("\n");

        context.close();
    }
}
