package ro.training.servicii;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

import ro.training.exceptions.DAOException;
import ro.training.repository.*;
import ro.training.structuri.Book;

@Service
public class BookService {
	@Autowired
	private BookRepo bookRepo;

	public BookRepo getBookRepository() {
		return bookRepo;
	}

	public void bookRepo(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	@Transactional
	public void insertBook(String Author, String Title, String Description, String Subject, int yearPublished, String borrowed)
			throws DAOException {
		Book book = new Book();
		// trebe facut in Loan ca acolo am many to one .
		// Loan loan = new Loan();
		// loan.setLoanId(loanId);
		// book.set
		// book.setRole(role);
		book.setAuthor(Author);
		book.setTitle(Title);
		book.setDescription(Description);
		
		book.setSubject(Subject);
		book.setYearPublished(yearPublished);
		book.setBorrowed(borrowed);
		bookRepo.insertBook(book);
	}

	@Transactional
	public void deleteBook(int bookId) throws DAOException {
		bookRepo.deleteBook(bookId);
	
	}
	

	

	@Transactional
	public void updateBook(int bookId, String Author, String Title, String Description, String Subject,
			int yearPublished,String borrowed) throws DAOException {
		Book book = new Book();

		// Role role = new Role();
		book.setAuthor(Author);

		book.setBookId(bookId);
		
		book.setTitle(Title);

		book.setDescription(Description);

		book.setSubject(Subject);

		book.setYearPublished(yearPublished);
		
		book.setBorrowed(borrowed);
		bookRepo.updateBook(book);

	}

	@Transactional
	public Book findBookById(int bookId) throws DAOException {
		return bookRepo.findBookById(bookId);
	}
	
	@Transactional
	public List<Book> listAllBooks() {
		return bookRepo.listBooks();
	}

}
