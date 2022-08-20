package com.spring.boot.command;

import java.math.BigDecimal;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductCommand {

	@TargetAggregateIdentifier
	private String productId;
	private String title;
	private BigDecimal price;
	private Integer quantity;
}
