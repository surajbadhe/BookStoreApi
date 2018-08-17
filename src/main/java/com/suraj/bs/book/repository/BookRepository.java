	package com.suraj.bs.book.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.suraj.bs.book.entity.Book;

/**
 * 
 * @author Suraj
 * This interface will take care of CRUD operation alos we have created some custome methods.
 */

public interface BookRepository extends CrudRepository<Book, String>{
		// looking Book by an ID of Book 
		public List<Book> findById(Long id);
		
		// looking Book by name
		public List<Book> findByBname(String bname);

		// looking Book by description
		public List<Book> findByDescription(String name);
	
}
