package ro.training.repository;

import java.util.List;

import ro.training.exceptions.DAOException;
import ro.training.structuri.Book;



public interface BookRepoInterface {

	
	
	public List<Book> listBooks();

	public int insertBook(Book book);

	public void deleteBook(int bookId) throws DAOException;

	public void updateBook(Book book) throws DAOException;

	public Book findBookById(int bookdId) throws DAOException;
	
	public Book findBookByTitle(String title) throws DAOException;
	
}
