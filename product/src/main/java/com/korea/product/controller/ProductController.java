package com.korea.product.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.product.dto.ProductDTO;
import com.korea.product.dto.ResponseDTO;
import com.korea.product.model.ProductEntity;
import com.korea.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {

	private final ProductService p_service;
	
	@GetMapping
	public ResponseEntity<?> productList() {
		List<ProductEntity> entities = p_service.findAll();
		List<ProductDTO> dtos = entities.stream()
								.map(ProductDTO::new)
								.collect(Collectors.toList());
		ResponseDTO<ProductDTO> response = ResponseDTO
											.<ProductDTO>builder()
											.data(dtos).build();
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping
	public ResponseEntity<?> createProduct(@RequestBody ProductDTO dto) {
		try {
			ProductEntity entity = ProductDTO.toEntity(dto);
			List<ProductEntity> entities = p_service.create(entity);
			List<ProductDTO> dtos = entities.stream().map(ProductDTO::new).collect(Collectors.toList());
			ResponseDTO<ProductDTO> response = ResponseDTO.<ProductDTO>builder().data(dtos).build();
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			String error = e.getMessage();
			ResponseDTO<ProductDTO> response = ResponseDTO.<ProductDTO>builder().error(error).build();
			return ResponseEntity.badRequest().body(response);
		}
	}
}
