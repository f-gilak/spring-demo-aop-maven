package com.fariba.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addSillyMember(){
        System.out.println(getClass()+": Donig stuff: ADDing a membership account");
    return  true;
    }
}
