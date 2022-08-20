package com.spring.boot.entity;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Setter
@Getter
public class Product {

	private String title;
	private BigDecimal price;
	private Integer quantity;
}
