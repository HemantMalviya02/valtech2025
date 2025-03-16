package com.valtech.training.ecommerce.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.ecommerce.entities.Order;

public interface OrderRepo extends JpaRepository<Order, Long>{

}
