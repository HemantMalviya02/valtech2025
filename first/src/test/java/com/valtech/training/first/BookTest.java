package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.first.services.BookService;

@SpringBootTest
public class BookTest {
	@Autowired
	private BookService bookService;
	
//	@Autowired
//	private AuthorService authorService;

	
	
	@Test
	void testBook() {
		assertEquals(6, bookService.getAllBooks().size());
		assertEquals(3, bookService.findAllByPriceGreaterThan(100).size());
		assertEquals(4, bookService.findAllByYearBetween(2000, 2006).size());
		assertEquals(2, bookService.findAllPriceByAuthorId(1).size());
		System.err.println(bookService.findAllByAuthorId(1));
		System.err.println(bookService.getBookInfoByAuthor(1));
	}
	
	@Test
	void testPublisherService() {
		
	}
	
	@Test
	void testAuthorService() {
		
	}
}
