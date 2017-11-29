package ro.training.controllere;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ro.training.servicii.BookService;


@Controller
public class Image{
	
	@Autowired
	private BookService bookService;

	// inject via application.properties

	@RequestMapping("/image")
	public String welcome(Map<String, Object> model) {

		

		
		return "/WEB-INF/jsp/images/carti.png";
	}
}
