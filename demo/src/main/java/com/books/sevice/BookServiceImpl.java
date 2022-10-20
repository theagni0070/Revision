package com.books.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.Dao.BooksDao;
import com.books.exceptions.BookException;
import com.books.model.Books;

@Service
public class BookServiceImpl implements BoosService{
	
	@Autowired
	private BooksDao booksDao;
	
	@Override
	public List<Books> getAll() throws BookException {
		
		List<Books> list  = booksDao.findAll();
		
		if(list.size()<1) {
			
			throw new BookException("Please enter some data first");
			
		}
		
		return list;
		
	}

	@Override
	public Books getById(Integer bookId) throws BookException {
		
		Optional<Books> op = booksDao.findById(bookId);
		
		return op.orElseThrow(() ->  new BookException("Invalid Book Id"));

	}

	@Override
	public Books createBook(Books book) throws BookException {
		
		return booksDao.save(book);
		
	}

	@Override
	public Books deleteBook(Integer bookId) throws BookException {
		
		Optional<Books> op = booksDao.findById(bookId);
		
		if(op.isEmpty())
			throw new BookException("No Such Book Exists");
		
		booksDao.deleteById(bookId);
		
		return op.get();
	}

	@Override
	public Books updateBook(Books book,Integer bookId) throws BookException {
		
		Optional<Books> op = booksDao.findById(bookId);
		
		if(op.isEmpty())
				throw new BookException("No such Book Found");
		
		return booksDao.save(book);
		
	}

}
