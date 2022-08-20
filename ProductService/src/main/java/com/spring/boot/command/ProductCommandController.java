package com.spring.boot.command;

import java.util.UUID;

import javax.validation.Valid;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.entity.ProductRestModel;

@RestController
@RequestMapping("/command")
public class ProductCommandController {

	private CommandGateway commandGateway;

	@Autowired
	public ProductCommandController(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}
	
	@PostMapping("/create-product")
	public String createProduct(@Valid @RequestBody ProductRestModel product) {

		ProductCommand createProductCommand = ProductCommand.builder().price(product.getPrice())
				.quantity(product.getQuantity())
				.title(product.getTitle())
				.productId(UUID.randomUUID().toString()).build();

		String returnValue = commandGateway.sendAndWait(createProductCommand);

		return returnValue;
	}
}
