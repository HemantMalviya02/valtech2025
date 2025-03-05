package com.valtech.training.first.entities;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Book {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
	@SequenceGenerator(name = "book_seq", sequenceName = "bookseq", allocationSize = 1)
	private int id;
	
	private String name;
	private int price;
	private int year;
	
	@ManyToOne
	@JoinColumn(name = "publisher_id", referencedColumnName = "id")
	private Publisher publisher;
	
	
//	@ManyToMany(targetEntity = Author.class, fetch = FetchType.LAZY)
//	@JoinTable(name = "book_author",
//	joinColumns = @JoinColumn(name="book_id", referencedColumnName = "id"),
//	inverseJoinColumns = @JoinColumn(name="author_id", referencedColumnName = "id"))
	
	@ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
	private Set<Author> author;
	
	

	public Book() {}

	public Book(String name, int price, int year) {
		this.name = name;
		this.price = price;
		this.year = year;
	}
	
	public void addAuthor(Author a) {
		if(author == null) 
				author = new HashSet<Author>();
		author.add(a);
		if(a.getBooks() == null) a.setBooks(new HashSet<Book>());
		a.getBooks().add(this);
	}
	
	public void removeAuthor(Author a) {
		author.remove(a);
		a.getBooks().remove(this); 
	}

	public void setAuthor(Set<Author> author) {
		this.author = author;
	}
	
	public Set<Author> getAuthor() {
		return author;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
}
