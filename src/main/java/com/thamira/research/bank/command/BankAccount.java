/*
 * Copyright (c) 2016. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.thamira.research.bank.command;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.thamira.research.bank.api.bankaccount.BankAccountCreatedEvent;
import com.thamira.research.bank.api.bankaccount.CreateBankAccountCommand;
import com.thamira.research.bank.api.bankaccount.DepositMoneyCommand;
import com.thamira.research.bank.api.bankaccount.MoneyAddedEvent;
import com.thamira.research.bank.api.bankaccount.MoneyDepositedEvent;
import com.thamira.research.bank.api.bankaccount.MoneySubtractedEvent;
import com.thamira.research.bank.api.bankaccount.MoneyWithdrawnEvent;
import com.thamira.research.bank.api.bankaccount.WithdrawMoneyCommand;

@Aggregate
public class BankAccount {

    @AggregateIdentifier
    private String id;
    private long overdraftLimit;
    private long balanceInCents;
	private String name;

    @SuppressWarnings("unused")
    private BankAccount() {
    }

    @CommandHandler
    public BankAccount(CreateBankAccountCommand command) {
        apply(new BankAccountCreatedEvent(command.getBankAccountId(), command.getOverdraftLimit(),command.getName()));
    }

    @CommandHandler
    public void deposit(DepositMoneyCommand command) {
    	System.err.println(id);
        apply(new MoneyDepositedEvent(id, command.getAmountOfMoney(),command.getName()));
    }

    @CommandHandler
    public void withdraw(WithdrawMoneyCommand command) {
        if (command.getAmountOfMoney() <= balanceInCents + overdraftLimit) {
            apply(new MoneyWithdrawnEvent(id, command.getAmountOfMoney(),command.getName()));
        }
    }

    @EventSourcingHandler
    public void on(BankAccountCreatedEvent event) {
        this.id = event.getId();
        this.overdraftLimit = event.getOverdraftLimit();
        this.balanceInCents = 0;
        this.name=event.getName();
    }

    @EventSourcingHandler
    public void on(MoneyAddedEvent event) {
    	System.err.println(balanceInCents);
        balanceInCents += event.getAmount();
        name=event.getName();
        System.err.println(name);
    }

    @EventSourcingHandler
    public void on(MoneySubtractedEvent event) {
        balanceInCents -= event.getAmount();
        
    }
}
