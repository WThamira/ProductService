package com.thamira.research.bank.handler;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.thamira.research.bank.api.bankaccount.BankAccountCreatedEvent;
import com.thamira.research.bank.api.bankaccount.MoneyAddedEvent;
import com.thamira.research.bank.api.bankaccount.MoneySubtractedEvent;

@Component
public class BankAccountEventListener {



    @EventHandler
    public void on(BankAccountCreatedEvent event) {
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

