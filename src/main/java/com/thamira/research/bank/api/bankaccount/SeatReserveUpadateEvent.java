package com.thamira.research.bank.api.bankaccount;

import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@NonFinal
public class SeatReserveUpadateEvent {
    private String myid;
	private String seatId;
}
