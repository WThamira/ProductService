package com.thamira.research.bank.controller;

import java.util.Map;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thamira.research.bank.api.bankaccount.CreateBankAccountCommand;
import com.thamira.research.bank.api.bankaccount.DepositMoneyCommand;

@RestController
public class TestController {
	
	private final CommandGateway commandGateway;
	
	
	public TestController(CommandGateway commandGateway) {
		this.commandGateway=commandGateway;
	}
	
	@PostMapping
    public String fileComplaint(@RequestBody Map<String, String> request) {
		String id = UUID.randomUUID().toString();
        CreateBankAccountCommand command = new CreateBankAccountCommand(id, Long.parseLong(request.get("seatid")),request.get("name"));
        commandGateway.send(command);
		return id;
        
    }
	
	@PatchMapping
    public String fileComplaintUpdate(@RequestBody Map<String, String> request) {
		DepositMoneyCommand command = new DepositMoneyCommand(request.get("id"), Long.parseLong(request.get("seatid")),request.get("name"));
        commandGateway.send(command);
        return request.get("id");
      
    }

}
