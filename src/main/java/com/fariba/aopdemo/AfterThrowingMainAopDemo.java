package com.fariba.aopdemo;

import com.fariba.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingMainAopDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = null;
        try {
            boolean tripWire=true;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("\n\nMain Program ... caught exception:" + e );
        }
        System.out.println("\n\nMain program: AfterThrowingDemoApp");
        System.out.println("---");
        System.out.println(accounts);
        System.out.println("\n");

        context.close();
    }
}
