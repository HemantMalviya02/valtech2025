package com.valtech.training.first.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.first.entities.Publisher;

public interface PublisherRepo extends JpaRepository<Publisher, Integer>{

}
