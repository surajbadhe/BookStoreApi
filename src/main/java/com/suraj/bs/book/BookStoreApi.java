package com.suraj.bs.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Book Store Application !
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.suraj.bs.book"})
public class BookStoreApi {
	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApi.class, args);
	}
}
