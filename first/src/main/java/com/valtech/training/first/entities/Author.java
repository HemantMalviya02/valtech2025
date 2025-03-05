package com.valtech.training.first.entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Author {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
	@SequenceGenerator(name = "author_seq", sequenceName = "authorseq", allocationSize = 1)
	private int id;
	
	private String name;
	private String address;
	
	@ManyToMany(targetEntity = Book.class, fetch = FetchType.LAZY)
	@JoinTable(name = "book_author",
			joinColumns = @JoinColumn(name = "author_id"),
			inverseJoinColumns = @JoinColumn(name="book_id")) 
	private Set<Book> books;
	
	public Author() {}
	
	public Author(String name, String address) {
		this.name = name;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	
	
}
