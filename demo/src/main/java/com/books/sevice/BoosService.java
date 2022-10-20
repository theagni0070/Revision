package com.books.sevice;

import java.util.List;

import com.books.exceptions.BookException;
import com.books.model.Books;

public interface BoosService {
	
	public List<Books> getAll() throws BookException;
	
	public Books getById(Integer bookId) throws BookException;
	
	public Books createBook(Books book) throws BookException;
	
	public Books deleteBook(Integer bookId) throws BookException;
	
	public Books updateBook(Books book,Integer bookId) throws BookException;
	
}
