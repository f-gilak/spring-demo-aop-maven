package com.fariba.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addSillyMember() {
        System.out.println(getClass() + ": Donig stuff: ADDing a membership account");
        return true;
    }

    public void goToSleep() {
        System.out.println(getClass() + ":I'm going to sleep now...");
    }
}
