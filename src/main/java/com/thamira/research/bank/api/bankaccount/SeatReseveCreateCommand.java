package com.thamira.research.bank.api.bankaccount;

import java.util.Date;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import lombok.Value;

@Value
public class SeatReseveCreateCommand {
	
	@TargetAggregateIdentifier
    private String myid;
	private String seatId;
	private Date date;
}
