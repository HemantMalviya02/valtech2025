package com.valtech.training.ecommerce.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.ecommerce.entities.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long>{

}
