package com.valtech.training.first.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.first.entities.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer>{

}
