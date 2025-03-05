package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.entities.Book;
import com.valtech.training.first.dtos.BookInfoDTO;


public interface BookService {
	Book save(Book book);
	Book update(Book book);
	void delete(Book book);
	Book getBook(int id);
	List<Book> getAllBooks();
	Long countAllBooks();
	List<Book> findAllByYearBetween(int min, int max);
	List<Book> findAllByPriceGreaterThan(int price);
	List<Book> findAllByAuthorId(long authorId);
	List<Integer> findAllPriceByAuthorId(long id);
	List<BookInfoDTO> getBookInfoByAuthor(long id);
}
