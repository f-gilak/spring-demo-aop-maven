package com.fariba.aopdemo;

import com.fariba.aopdemo.dao.AccountDAO;
import com.fariba.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyMainAopDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<String> list=null;
        try {
            list=accountDAO.findList(true);
        }catch (Exception e){
            System.out.println("\n\nmain program ... caught exception:"+e);
        }
        System.out.println("\n\nmain program ... AfterThrowingDemoAp:");

        context.close();
    }
}
