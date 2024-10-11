package com.korea.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.product.model.ProductEntity;
import com.korea.product.persistence.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository p_repository;
	
	public List<ProductEntity> findAll() {
		return p_repository.findAll();
	}
	
	//추가하기
	public List<ProductEntity> create(final ProductEntity entity) {
		validate(entity);
		
		p_repository.save(entity);
		return p_repository.findAll();
	}
	
	private void validate(final ProductEntity entity) {
		if(entity == null) {
			throw new RuntimeException("Entity can't be null");
		}
	}
}
