package ro.training.controllere;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import ro.training.servicii.*;
import ro.training.structuri.*;
import ro.training.exceptions.DAOException;
import ro.training.inputs.BookInput;
import ro.training.reponse.Response;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	// get
	@RequestMapping(value = "/books/getall", method = RequestMethod.GET)
	public @ResponseBody Response getBooks() {
		Response response = new Response();

		try {
			List<Book> listOfBooks = bookService.listAllBooks();

			response.setSuccess(true);
			response.setData(listOfBooks);
		} catch (Exception e) {
			System.out.println(e);
		}

		return response;
	
	}
	

	
	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpSession session, Model model) {
		session.setAttribute("book_list", bookService.listAllBooks());
		model.addAttribute("books", bookService.listAllBooks());
		return "book/list";
	}
	@RequestMapping(value = "books/getallaa", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("books", bookService.listAllBooks());
		return "book/list";
	}

	// get by id
	@RequestMapping(value = "/books/get/{bookId}", method = RequestMethod.GET)
	public @ResponseBody Response findBookById(@PathVariable int bookId) {
		Response response = new Response();

		try {
			Book book = new Book();
			book = bookService.findBookById(bookId);

			response.setSuccess(true);
			response.setData(book);
		} catch (Exception e) {
			response.setSuccess(false);
		}

		return response;
	}
	
	// post
	@RequestMapping(value = "/books/{bookId}", method = RequestMethod.POST)
	public Response insertBook(@RequestBody BookInput bookInput, HttpServletRequest request) {
		Response response = new Response();

		try {

			bookService.insertBook(bookInput.getAuthor(), bookInput.getTitle(), bookInput.getDescription(),
					bookInput.getSubject(), bookInput.getYearPublished(), bookInput.getBorrowed());
			response.setSuccess(true);
		} catch (Exception e) {
			response.setSuccess(false);
		}
		return response;
	}
	// patch

	@RequestMapping(value = "/books/{bookId}", method = RequestMethod.PATCH)
	public Response updateBook(@PathVariable("bookId") int bookId, @RequestBody BookInput bookInput,
			HttpServletRequest request) {
		Response response = new Response();

		try {

			bookService.updateBook(bookInput.getBookId(), bookInput.getAuthor(), bookInput.getTitle(),
					bookInput.getDescription(), bookInput.getSubject(), bookInput.getYearPublished(),
					bookInput.getBorrowed());
			response.setSuccess(true);
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	
	

	@RequestMapping(value = "/delete/{bookId}", method = RequestMethod.POST)
	public String delete(@PathVariable int bookId) {
		try {
			Book book = bookService.findBookById(bookId);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bookService.deleteBook(bookId);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:books/getallaa";
	}

	
	
	// delete

	@RequestMapping(value = "/books/{bookId}", method = RequestMethod.DELETE)
	public Response deleteBook(@PathVariable("bookId") int bookId, HttpServletRequest request) {
		Response response = new Response();

		try {

			bookService.deleteBook(bookId);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setSuccess(false);
		}

		return response;
	}
}
