package com.fariba.aopdemo;

import com.fariba.aopdemo.dao.AccountDAO;
import com.fariba.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAopDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO=context.getBean("membershipDAO",MembershipDAO.class);
        accountDAO.addAccount();
        membershipDAO.addSillyMember();
        System.out.println("\nlet's call it again!\n");
        accountDAO.addAccount();
        membershipDAO.addSillyMember();

        context.close();
    }
}
