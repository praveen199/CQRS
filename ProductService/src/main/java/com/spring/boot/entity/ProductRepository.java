package com.spring.boot.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

	ProductEntity findByProductId(String productId);
	ProductEntity findByProductIdOrTitle(String productId,String title);
}
