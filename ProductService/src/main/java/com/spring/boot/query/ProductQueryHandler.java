package com.spring.boot.query;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.spring.boot.entity.ProductEntity;
import com.spring.boot.entity.ProductRepository;
import com.spring.boot.entity.ProductRestModel;

@Component
public class ProductQueryHandler {

	private final ProductRepository productRepository;
	
	public ProductQueryHandler(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@QueryHandler
	public List<ProductRestModel> findProduct(FindProductQuery query) {
		
		List<ProductRestModel> productRest = new ArrayList<>();
		
		List<ProductEntity> sharedProducts = productRepository.findAll();
		
		for(ProductEntity productEntity : sharedProducts) {
			ProductRestModel productRestModel = new ProductRestModel();
			BeanUtils.copyProperties(productEntity, productRestModel);
			
			productRest.add(productRestModel);
		}
		return productRest; 
	}
}
