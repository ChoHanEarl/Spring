package com.korea.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.korea.product.dto.ProductDTO;
import com.korea.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductController {

	private final ProductService service;
	
	//상품추가
	@PostMapping
	   public ResponseEntity<?> addProduct(){
	      return ResponseEntity.ok().body(service.addProduct());
	   }
	
	//상품 조회
	@GetMapping
	public ResponseEntity<?> getAllProducts(
			@RequestParam(value = "minPrice", required = false) Double minPrice,
			@RequestParam(value = "name", required = false) String name) {
		List<ProductDTO> products = service.getFilteredProducts(minPrice, name);
		return ResponseEntity.ok(products);
	}
	
	//상품 수정
	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable int id, @RequestBody ProductDTO productDTO) {
		ProductDTO updatedProduct = service.updateProduct(id, productDTO);
		if(updatedProduct != null) {
			return ResponseEntity.ok(updatedProduct);
		}
		return ResponseEntity.notFound().build();
	}
	
}
