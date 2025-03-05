package com.valtech.training.first.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Publisher {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pub_seq")
	@SequenceGenerator(name = "pub_seq", sequenceName = "pubseq", allocationSize = 1)
	private int id;
	private String name;
	
	@OneToMany(targetEntity = Book.class, mappedBy = "publisher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Book> books;
	
	public Publisher () {}
	
	public void addBook(Book book) {
		if(books == null) 
				books = new HashSet<Book>();
				books.add(book);
				book.setPublisher(this);
	}

	public void removeBook(Book book) {
		books.add(book);
		book.setPublisher(this);
	}
	
	public Publisher(String name, Set<Book> books) {
		this.name = name;
		this.books = books;
	}



	public Publisher(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
