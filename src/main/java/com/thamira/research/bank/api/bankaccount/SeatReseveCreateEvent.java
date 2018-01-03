package com.thamira.research.bank.api.bankaccount;

import java.util.Date;

import lombok.Value;

@Value
public class SeatReseveCreateEvent {
	private String id;
	private String seatId;
	private Date date;
}
