package com.fariba.aopdemo;

import com.fariba.aopdemo.dao.AccountDAO;
import com.fariba.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAopDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO=context.getBean("membershipDAO",MembershipDAO.class);
        Account account=new Account();
        account.setName("fariba");
        account.setLevel("gold ");
        accountDAO.addAccount(account,true);
        accountDAO.doWork();
        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        String name=accountDAO.getName();
        String code=accountDAO.getServiceCode();
        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();
//        System.out.println("\nlet's call it again!\n");
//        accountDAO.addAccount(account);
//        membershipDAO.addSillyMember();

        context.close();
    }
}
