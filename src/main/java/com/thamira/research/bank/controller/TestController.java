package com.thamira.research.bank.controller;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thamira.research.bank.api.bankaccount.SeatReserveUpadateCommand;
import com.thamira.research.bank.api.bankaccount.SeatReseveCreateCommand;

@RestController
public class TestController {
	
	private final CommandGateway commandGateway;
	
	
	public TestController(CommandGateway commandGateway) {
		this.commandGateway=commandGateway;
	}
	
	@PostMapping
    public String fileComplaint(@RequestBody Map<String, String> request) {
		String id = UUID.randomUUID().toString();
		SeatReseveCreateCommand command=new SeatReseveCreateCommand(id,request.get("seatid"),new Date(request.get("date")));
        commandGateway.send(command);
		return id;
    }
	
	@PatchMapping
    public String fileComplaintUpdate(@RequestBody Map<String, String> request) {
		SeatReserveUpadateCommand command= new SeatReserveUpadateCommand(request.get("id"),request.get("seatid"));
		commandGateway.send(command);
        return request.get("id");
    }

}
