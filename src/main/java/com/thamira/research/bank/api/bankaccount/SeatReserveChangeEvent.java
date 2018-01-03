package com.thamira.research.bank.api.bankaccount;

public class SeatReserveChangeEvent extends SeatReserveUpadateEvent {
	public SeatReserveChangeEvent(String id,String seatId) {
		super(id, seatId);
	}
}
