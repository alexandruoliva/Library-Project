package ro.training.controllere;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ro.training.servicii.BookService;

@Controller
public class BookWelcomeSave {

	@Autowired
	private BookService bookService;

	// inject via application.properties

	@RequestMapping("/bookss")
	public String welcome(Map<String, Object> model) {

		return "/book/save";
	}

}