package com.valtech.training.ecommerce.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.ecommerce.entities.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
