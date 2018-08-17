package com.suraj.bs.book.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.bs.book.entity.Book;
import com.suraj.bs.book.service.BookService;



/**
 * @author SurajBadhe
 *         <p>
 *         Rest controller to serve basic operations on book entity.
 *         </p>
 */
@RestController
@RequestMapping(Constants.BOOK_ENDPOINT)
public class BookController {

	Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	/**
	 * <p>
	 * Fetches all books from memory.
	 * </p>
	 *
	 * @return
	 */
	@RequestMapping(value = Constants.ENDPOINT_SEPARATOR, method = RequestMethod.GET, produces = Constants.APPLICATION_PRODUCER_TYPE)
	public ResponseEntity<List<Book>> getAllBooks() {
		logger.info("REST request received to fetch all books.");
		final List<Book> lstAllBooksFound = bookService.getAll();
		if (CollectionUtils.isEmpty(lstAllBooksFound)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Book>>(lstAllBooksFound, HttpStatus.OK);
	}

	/**
	 * <p>
	 * Returns an instance of a book after searching based on an isbn id.
	 * </p>
	 *
	 * @param isbnId
	 * @return
	 */
	@RequestMapping(value = Constants.BY_ID, method = RequestMethod.GET, produces = Constants.APPLICATION_PRODUCER_TYPE)
	public ResponseEntity<Book> getBook(@PathVariable Long id) {
		logger.info("REST request received to fetch book: {0}", id);
		final Book bookFetched = bookService.get(id);
		
		if (bookFetched != null) {
			return new ResponseEntity<Book>(bookFetched, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * <p>
	 * Creates a new book.
	 * </p>
	 *
	 * @param incommingBook
	 * @return
	 */
	@RequestMapping(value = Constants.ENDPOINT_SEPARATOR, method = RequestMethod.POST, produces = Constants.APPLICATION_PRODUCER_TYPE)
	public ResponseEntity<Book> createBook(@RequestBody final Book incommingBook) {
		logger.info("REST request received to create book.");
		final Book savedBook = bookService.save(incommingBook);
		if (savedBook != null) {
			return new ResponseEntity<Book>(savedBook, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * <p>
	 * Updates a book instance based on the isbn id present in path variable.
	 * </p>
	 *
	 * @param isbnId
	 * @param incommingBook
	 * @return
	 */
	@RequestMapping(value =Constants.BY_ID, method = RequestMethod.PUT, produces = Constants.APPLICATION_PRODUCER_TYPE)
	public ResponseEntity<Book> updateBookDetail(@PathVariable final Long id,
			@RequestBody final Book incommingBook) {
		logger.info("REST request received to update book: {0}", id);
		final Book updatedBook = bookService.update(id, incommingBook);
		if (updatedBook != null) {
			return new ResponseEntity<Book>(updatedBook, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * <p>
	 * Deletes a book by searching for isbn id.
	 * </p>
	 *
	 * @param isbnId
	 * @return
	 */
	@RequestMapping(value = Constants.BY_ID, method = RequestMethod.DELETE, produces = Constants.APPLICATION_PRODUCER_TYPE)
	public ResponseEntity<Object> deleteBook(@PathVariable final Long isbnId) {
		logger.info("REST request received to delete book: {0}", isbnId);
		bookService.delete(isbnId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
