package com.thamira.research.bank.command;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import java.util.Date;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.thamira.research.bank.api.bankaccount.SeatReserveChangeEvent;
import com.thamira.research.bank.api.bankaccount.SeatReserveUpadateCommand;
import com.thamira.research.bank.api.bankaccount.SeatReserveUpadateEvent;
import com.thamira.research.bank.api.bankaccount.SeatReseveCreateCommand;
import com.thamira.research.bank.api.bankaccount.SeatReseveCreateEvent;

@Aggregate
public class SeatReserve {
	@AggregateIdentifier
	private String id;
	private String seatid;
	private Date date;

	@SuppressWarnings("unused")
	private SeatReserve() {
	}

	@CommandHandler
	public SeatReserve(SeatReseveCreateCommand seatReseveCreateCommand) {
		apply(new SeatReseveCreateEvent(seatReseveCreateCommand.getMyid(), seatReseveCreateCommand.getSeatId(),
				seatReseveCreateCommand.getDate()));
	}

	@CommandHandler
	public SeatReserve(SeatReserveUpadateCommand upadateCommand) {
		apply(new SeatReserveUpadateEvent(id, upadateCommand.getSeatId()));
	}

	@EventSourcingHandler
	public void on(SeatReseveCreateEvent seatReseveCreateEvent) {
		this.id = seatReseveCreateEvent.getId();
		this.seatid = seatReseveCreateEvent.getSeatId();
		this.date = seatReseveCreateEvent.getDate();
	}

	@EventSourcingHandler
	public void on(SeatReserveChangeEvent upadateEvent) {
		seatid = upadateEvent.getSeatId();
	}

}
