package com.books.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.books.model.Books;

@Repository
public interface BooksDao extends JpaRepository<Books, Integer>{	
}
