package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.entities.Book;
import com.valtech.training.first.repos.AuthorRepo;
import com.valtech.training.first.repos.BookRepo;
import com.valtech.training.first.dtos.BookInfoDTO;
import com.valtech.training.first.repos.PublisherRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BookServiceImpl implements BookService{

	
	@Autowired
	private BookRepo bookRepo;
	
//	@Autowired
//	private PublisherRepo publisherRepo;
//	
//	@Autowired
//	private AuthorRepo authorRepo;
	
	
	
	
	@Override
	public Book save(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public Book update(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public void delete(Book book) {
		bookRepo.delete(book);
	}

	@Override
	public Book getBook(int id) {
		return bookRepo.getReferenceById(id);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	
	@Override
	public Long countAllBooks() {
		return bookRepo.count();
	}

	@Override
	public List<Book> findAllByYearBetween(int min, int max) {
		return bookRepo.findAllByYearBetween(min, max);
	}

	@Override
	public List<Book> findAllByPriceGreaterThan(int price) {
		return bookRepo.findAllByPriceGreaterThan(price);
	}

	@Override
	public List<Book> findAllByAuthorId(long authorId) {
		return bookRepo.findAllByAuthorId(authorId);
	}

	@Override
	public List<Integer> findAllPriceByAuthorId(long id) {
		return bookRepo.findAllPriceByAuthorId(id);
	}

	@Override
	public List<BookInfoDTO> getBookInfoByAuthor(long id) {
		return bookRepo.getBookInfoByAuthor(id);
	}

	
}
