package org.javacream.books.warehouse.impl;

import java.util.Collection;
import java.util.Optional;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.store.BooksStoreService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksRepository;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class JpaBooksService implements BooksService {

	@Autowired
	@IsbnGenerator.SequenceStrategy
	private IsbnGenerator isbnGenerator;
	@Autowired
	private BooksStoreService storeService;
	@Autowired
	private BooksRepository booksRepository;
	public String newBook(String title) throws BookException {
		String isbn = isbnGenerator.next();
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		booksRepository.save(book);
		return isbn;
	}

	public Book findBookByIsbn(String isbn) throws BookException {

		Optional<Book> result = booksRepository.findById(isbn);
		if (result.isPresent()) {
			Book book = result.get();
			book.setAvailable(Integer.parseInt(storeService.getStockForBook("books", isbn)) > 0);
			return book;
		}
		throw new BookException(BookException.BookExceptionType.NOT_FOUND, isbn);

	}

	public Book updateBook(Book bookValue) throws BookException {
		try {
			booksRepository.save(bookValue);
			return bookValue;
		} catch (RuntimeException e) {
			throw new BookException(BookException.BookExceptionType.CONSTRAINT, e.getMessage());
		}
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		if (booksRepository.existsById(isbn)){
			booksRepository.deleteById(isbn);
		} else {
			throw new BookException(BookException.BookExceptionType.NOT_DELETED, isbn);
		}
	}

	public Collection<Book> findAllBooks() {
		return booksRepository.findAll();
	}}
