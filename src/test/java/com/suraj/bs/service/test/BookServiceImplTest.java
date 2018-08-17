package com.suraj.bs.service.test;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.suraj.bs.book.entity.Book;
import com.suraj.bs.book.repository.BookRepository;
import com.suraj.bs.book.service.BookService;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class BookServiceImplTest {

	@Tested
	private BookService bookServiceImpl;

	@Injectable
	private BookRepository bookRepository;

	@Test
	public void testGetAllFail() {
		new Expectations() {
			{
				bookRepository.findAll();
				result = null;
			}
		};
		final List<Book> all = this.bookServiceImpl.getAll();
		Assertions.assertThat(all).isNull();
	}

	@Test
	public void testGetAllSuccess() {
		final Book testBook = new Book();
		new Expectations() {
			{
				bookRepository.findAll();
				result = Arrays.asList(testBook);
			}
		};
		final List<Book> all = this.bookServiceImpl.getAll();
		Assertions.assertThat(all).isNotNull();
		Assertions.assertThat(all).hasSize(1);
	}

	@Test
	public void testGetFail() {
		new Expectations() {
			{
				bookRepository.findOne(Long.toString(anyLong));
				result = null;
			}
		};
		final Book book = this.bookServiceImpl.get(786L);
		Assertions.assertThat(book).isNull();
	}

	@Test
	public void testGetSuccess() {
		final Book testBook = new Book();
		new Expectations() {
			{
				bookRepository.findOne(Long.toString(anyLong));
				result = testBook;
			}
		};
		final Book book = this.bookServiceImpl.get(786L);
		Assertions.assertThat(book).isNotNull();
	}

	@Test
	public void testSaveFail() {
		final Book testBook = new Book();
		new Expectations() {
			{
				bookRepository.save(testBook);
				result = null;
			}
		};
		final Book book = this.bookServiceImpl.save(testBook);
		Assertions.assertThat(book).isNull();
	}

	@Test
	public void testSaveSuccess() {
		final Book testBook = new Book();
		new Expectations() {
			{
				bookRepository.save(testBook);
				result = testBook;
			}
		};
		final Book book = this.bookServiceImpl.save(testBook);
		Assertions.assertThat(book).isNotNull();
	}

	@Test
	public void testUpdateFailTest() {
		final Book testBook = new Book();
		new Expectations() {
			{
				bookRepository.save(testBook);
				result = null;
			}
		};
		final Book update = this.bookServiceImpl.update(123L, testBook);
		Assertions.assertThat(update).isNull();
	}

	@Test
	public void testUpdateSuccessTest() {
		final Book testBook = new Book();
		new Expectations() {
			{
				bookServiceImpl.save(testBook);
				result = testBook;
			}
		};
		final Book update = this.bookServiceImpl.update(123L, testBook);
		Assertions.assertThat(update).isNotNull();
	}
}
