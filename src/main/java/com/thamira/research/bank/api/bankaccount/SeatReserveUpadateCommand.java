package com.thamira.research.bank.api.bankaccount;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import lombok.Value;
@Value
public class SeatReserveUpadateCommand {
	@TargetAggregateIdentifier
    private String myid;
	private String seatId;
}
