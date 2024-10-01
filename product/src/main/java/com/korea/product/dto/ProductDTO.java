package com.korea.product.dto;

import com.korea.product.model.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor //builder패턴을 사용하려면 있어야 한다.
public class ProductDTO {
	int id;
	String name;
	String description;
	double price;
	
	//Entity -> DTO
	public ProductDTO(ProductEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
	}
	
	//DTO -> Entity
	public static ProductEntity toEntity(ProductDTO dto) {
		return ProductEntity.builder()
				.id(dto.getId())
				.name(dto.getName())
				.description(dto.getDescription())
				.price(dto.getPrice())
				.build();
	}
}
