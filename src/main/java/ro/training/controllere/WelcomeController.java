package ro.training.controllere;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ro.training.servicii.BookService;
import ro.training.structuri.Book;

@Controller
public class WelcomeController {
	
	@Autowired
	private BookService bookService;

	// inject via application.properties

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", "Hello Fortech!");
		Book asd= new Book();
		asd.setAuthor("ads");
		asd.setBookId(1);
		model.put("dddd", asd);
		
		List<Book> listOfBooks = bookService.listAllBooks();
		model.put("carti", listOfBooks);

		
		return "index";
	}

}