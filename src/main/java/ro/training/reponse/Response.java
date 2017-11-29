package ro.training.reponse;

import ro.training.structuri.Book;

public class Response {

	private boolean success;
	private Object data;
	private String message;
	private Book book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book ) {
		this.book = book;
	}

	public Response() {
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
