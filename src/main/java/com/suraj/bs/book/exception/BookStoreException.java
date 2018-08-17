package com.suraj.bs.book.exception;

public class BookStoreException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorMessage;
 
	public String getErrorMessage() {
		return errorMessage;
	}
	public BookStoreException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	public BookStoreException() {
		super();
	}
}
