package com.spring.boot.command;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.spring.boot.entity.ProductEntity;
import com.spring.boot.entity.ProductRepository;

@Component
public class ProductEventHandler {

	private ProductRepository productRepository;
	
	public ProductEventHandler(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@EventHandler
	public void on(ProductCreatedEvent event) {
		
		ProductEntity productEntity = new ProductEntity();
		BeanUtils.copyProperties(event, productEntity);
		
		productRepository.save(productEntity);
	}
}
