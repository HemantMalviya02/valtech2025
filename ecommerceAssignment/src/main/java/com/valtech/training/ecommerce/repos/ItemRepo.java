package com.valtech.training.ecommerce.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.ecommerce.entities.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long>{

}
