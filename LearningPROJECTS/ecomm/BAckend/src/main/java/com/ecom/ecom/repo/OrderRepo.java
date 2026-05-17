package com.ecom.ecom.repo;

import com.ecom.ecom.model.Order;
import com.ecom.ecom.model.dto.OrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {
    Optional<OrderResponse> findByOrderId(String name);
}
