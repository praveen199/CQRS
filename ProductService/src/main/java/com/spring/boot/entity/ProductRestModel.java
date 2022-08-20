package com.spring.boot.entity;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ProductRestModel {
	
	@NotBlank(message = "Product title is a required field")
	private String title;
	
	@Min(value=1,message = "Price can not be lower then 1")
	private BigDecimal price;
	
	@Min(value=1,message = "Price can not be lower then 1")
	@Max(value=5,message = "Price can not be greater then 1")
	private Integer quantity;
}
