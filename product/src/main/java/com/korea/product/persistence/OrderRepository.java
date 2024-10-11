package com.korea.product.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.korea.product.model.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{

	//총 결제금액
	//상품가격(Product 테이블) * 주문개수(Order테이블)
	//필연적으로 Join을 할 수 밖에 없다. 쿼리문 작성
	
	@Query("select o.orderId, " //상품번호
			+ "o.product.productName, " //상품이름
			+ "o.productCount, " //주문개수
			+ "o.product.productPrice, " //상품단가
			+ "(o.product.productPrice * o.productCount) AS totalPrice, " //총 결제금액
			+ "o.orderDate " //주문날짜
			+ "from OrderEntity o")
	List<Object[]> findAllOrderTotalPrices();
}
