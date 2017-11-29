package ro.training.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ro.training.exceptions.*;
import ro.training.structuri.Book;


@Repository
public class BookRepo implements BookRepoInterface  {

	@PersistenceContext
	EntityManager em;



	public List<Book> listBooks() {
		return em.createQuery("FROM Book b", Book.class).getResultList();

	}

	public int insertBook(Book book) {
		em.persist(book);
		em.flush();
		return book.getBookId();
	}

	public void deleteBook(int bookId) throws DAOException {

		Book book  = em.find(Book.class, bookId);
		if (book!= null) {
			em.remove(book);
		} else {
			throw new DAOException("Book with id : " + bookId + " not found");
		}
	}

	public void updateBook(Book book) throws DAOException {
		int bookId = book.getBookId();

		Book foundBook = em.find(Book.class, bookId);
		if (foundBook != null) {
			foundBook.setAuthor(book.getAuthor());
			foundBook.setTitle(book.getTitle());
			foundBook.setDescription(book.getDescription());
			foundBook.setSubject(book.getSubject());
			foundBook.setYearPublished(book.getYearPublished());
			foundBook.setBorrowed(book.getBorrowed());
			em.merge(foundBook);
		} else {
			throw new DAOException("Book not found [id " + bookId + "]");
		}
		em.merge(book);
	}

	public Book findBookById(int bookId) {

		Book book = em.find(Book.class, bookId);
		return book;
	}
	@Override
	public Book findBookByTitle(String  Title) throws DAOException {

		TypedQuery<Book> query = em.createQuery("FROM Book b WHERE b.Title = :Title", Book.class);
		query.setParameter("Title", Title);

		return query.getSingleResult();
	}

	
}