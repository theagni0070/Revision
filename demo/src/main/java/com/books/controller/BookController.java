package com.books.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.books.exceptions.BookException;
import com.books.model.Books;
import com.books.sevice.BoosService;

@RestController
@RequestMapping("/bookservice/")
public class BookController {
	
	@Autowired
	private BoosService bookservice;
	
	
	@GetMapping("/books/")
	public ResponseEntity<List<Books>> getAll() throws BookException{
		
		return new ResponseEntity<List<Books>>(bookservice.getAll(),HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Books> getById(@PathVariable Integer id) throws BookException{
		
		return new ResponseEntity<Books>(bookservice.getById(id),HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping("/books/")
	public ResponseEntity<Books> createBook(@RequestBody Books book) throws BookException{
		
		return new ResponseEntity<Books>(bookservice.createBook(book),HttpStatus.CREATED);
		
	}
	
	@PutMapping("/books/")
	public ResponseEntity<Books> updateBook(@RequestBody Books book,@RequestParam("id") Integer bookId) throws BookException{
		
		return new ResponseEntity<Books>(bookservice.updateBook(book, bookId),HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/books/")
	public ResponseEntity<Books> deleteById(@RequestParam("id") Integer bookId) throws BookException{
		
		return new ResponseEntity<Books>(bookservice.deleteBook(bookId),HttpStatus.GONE);
		
	}
}
