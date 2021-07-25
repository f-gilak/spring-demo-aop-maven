package com.fariba.aopdemo.dao;

import com.fariba.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private  String name;
    private  String serviceCode;

    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": Doing my DB work: Adding an account");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return true;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public List<Account> findAccounts(boolean tripWire){
        if(tripWire){
            throw new RuntimeException("No soup for you!!");
        }
        List<Account> accounts=new ArrayList<Account>();
        Account account=new Account("fari","silver");
        Account account1=new Account("pari","gold");
        Account account2=new Account("hari","silver");
        Account account3  =new Account("sari","platinum");

        accounts.add(account);
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
System.out.println("----in method findAccounts-----");
        return accounts;
    }
}
