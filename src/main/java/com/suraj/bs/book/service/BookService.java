package com.suraj.bs.book.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suraj.bs.book.entity.Book;
import com.suraj.bs.book.repository.BookRepository;

/**
 * @author SurajBadhe
 */
@Service
public class BookService {
		
	Logger logger = LoggerFactory.getLogger(BookService.class);
	
	@Autowired
	private BookRepository bookCrud;
	
	public List<Book> getAll() {
		logger.info("Fetching all books from repository BookService");
		List<Book> books = new ArrayList<>();
		bookCrud.findAll().forEach(books::add);
		return books;
		 
	}

	public Book get(final Long searchParam) {
		logger.info("Searching a book from repository based on id");
		
		return bookCrud.findOne(Long.toString(searchParam));
	}
	
	public List<Book> getByID(final Long searchParam) {
		logger.info("Searching a book from repository based on id");
		return bookCrud.findById(searchParam);
		//return bookCrud.findOne(Long.toString(searchParam));
	}
	
	public Book save(final Book incommingItem) {
		logger.info("Saving a book in repository");
		return bookCrud.save(incommingItem);
	}
	
	public Iterable<Book> saveAll(List<Book> books) {
		logger.info("Saving a book in repository");
		return bookCrud.save(books);
	}

	
	public Book update(final Long id, final Book incommingItem) {
		logger.info("Updating a book in repository based on a particular id.");
		return bookCrud.save(incommingItem);
	}

	
	public void delete(final Long deleteId) {
		logger.info("Delete a book from repository based on an id");
		bookCrud.delete(Long.toString(deleteId));
	}
	
	/**
	 * As we have used the Derby DB to perform CRUD operation, here we are adding some bookes into DB by reading Json file.
	 * So as soon as the spring application boots up this datastructure will take care of
	 * books for us.
	 */
	
	@PostConstruct
	public void init() {
		List<Book> bookList=new ArrayList<Book>();
		
		JSONParser parser = new JSONParser();
		JSONArray jsonArray;
		try {
			jsonArray = (JSONArray) parser.parse(new FileReader("src/main/resources/books.json"));
			 for (Object o : jsonArray) {
				    
		            JSONObject person = (JSONObject) o;
		            Long id = (Long)person.get("id");
		            String strName = (String) person.get("bname");
		            String strAuthor = (String) person.get("bauthor");
		            Long quantity = (Long) person.get("quantity");
		            Long price = (Long) person.get("bprice");
		            String strDesc = (String) person.get("description");
		            bookList.add(new Book(id,strName,strAuthor,quantity,price,strDesc));
		            
		        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		bookCrud.save(bookList);
		
		
	}
	
}
