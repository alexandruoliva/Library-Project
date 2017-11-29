package ro.training.controllere;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ro.training.servicii.*;
import ro.training.structuri.*;
import ro.training.inputs.BorrowerInput;
import ro.training.reponse.Response;

@Controller
public class BorrowerController {

	@Autowired
	private BorrowerService borrowerService;

	// get
	@RequestMapping(value = "/borrowers/getall", method = RequestMethod.GET)
	public @ResponseBody Response getBooks() {
		Response response = new Response();

		try {
			List<Borrower> listBorrowers = borrowerService.listAllBorrowers();

			response.setSuccess(true);
			response.setData(listBorrowers);
		} catch (Exception e) {
			System.out.println(e);
		}

		return response;
	}

	// get by id
	@RequestMapping(value = "/borrowers/get/{borrowerId}", method = RequestMethod.GET)
	public @ResponseBody Response findBorrowerById(@PathVariable int borrowerId) {
		Response response = new Response();

		try {
			Borrower borrower = new Borrower();
			borrower = borrowerService.findBorrowerById(borrowerId);

			response.setSuccess(true);
			response.setData(borrower);
		} catch (Exception e) {
			response.setSuccess(false);
		}

		return response;
	}

	// post
	@RequestMapping(value = "/borrowers", method = RequestMethod.POST)
	public Response insertBorrower(@RequestBody BorrowerInput borrowerInput, HttpServletRequest request) {
		Response response = new Response();

		try {

			borrowerService.insertBorrower(borrowerInput.getAdress(), borrowerInput.getCity(), borrowerInput.getEmail(),
					borrowerInput.getName(), borrowerInput.getPassword(), borrowerInput.getPhoneNo());
			response.setSuccess(true);
		} catch (Exception e) {
			response.setSuccess(false);
		}
		return response;
	}
	// patch

	@RequestMapping(value = "/borrowers/{borrowerId}", method = RequestMethod.PATCH)
	public Response updateBorrower(@PathVariable("borrowerId") int borrowerId, @RequestBody BorrowerInput borrowerInput,
			HttpServletRequest request) {
		Response response = new Response();

		try {

			borrowerService.updateBorrower(borrowerInput.getBorrowerId(), borrowerInput.getPassword(),
					borrowerInput.getName(), borrowerInput.getAdress(), borrowerInput.getCity(),
					borrowerInput.getEmail(), borrowerInput.getPhoneNo());
			response.setSuccess(true);
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}


	@RequestMapping(value = "/borrowers/{borrowerId}", method = RequestMethod.DELETE)
	public Response deleteBorrower(@PathVariable("borrowerId") int borrowerId, HttpServletRequest request) {
		Response response = new Response();

		try {

			borrowerService.deleteBorrower(borrowerId);
			;
			response.setSuccess(true);
		} catch (Exception e) {
			response.setSuccess(false);
		}

		return response;
	}
}
