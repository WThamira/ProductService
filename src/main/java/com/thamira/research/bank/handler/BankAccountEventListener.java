package com.thamira.research.bank.handler;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.thamira.research.bank.api.bankaccount.AccountCreatedEvent;
import com.thamira.research.bank.api.bankaccount.MoneyAddedEvent;
import com.thamira.research.bank.api.bankaccount.MoneySubtractedEvent;

@Component
public class BankAccountEventListener {



    @EventHandler
    public void on(AccountCreatedEvent event) {
        System.err.println(event.getId());
    }

    @EventHandler
    public void on(MoneyAddedEvent event) {
    	System.err.println(event.getName());
    }

    @EventHandler
    public void on(MoneySubtractedEvent event) {
       
    }

    private void broadcastUpdates() {
       
    }

}

