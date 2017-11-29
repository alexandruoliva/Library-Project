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
import org.springframework.web.bind.annotation.RestController;

import ro.training.servicii.*;
import ro.training.structuri.*;
import ro.training.inputs.LoanInput;
import ro.training.reponse.Response;

@Controller
public class LoanController {

	@Autowired
	private LoanService loanService;

	// get
	@RequestMapping(value = "/loans", method = RequestMethod.GET)
	public @ResponseBody Response getLoans() {
		Response response = new Response();

		try {
			List<Loan> listOfLoans = loanService.listAllLoans();

			response.setSuccess(true);
			response.setData(listOfLoans);
		} catch (Exception e) {
			System.out.println(e);
		}

		return response;
	}

	// get by id
	@RequestMapping(value = "/loans/{loanId}", method = RequestMethod.GET)
	public @ResponseBody Response findLoanById(@PathVariable int loanId) {
		Response response = new Response();

		try {
			Loan loan = new Loan();
			loan = loanService.getLoanById(loanId);

			response.setSuccess(true);
			response.setData(loan);
		} catch (Exception e) {
			response.setSuccess(false);
		}

		return response;
	}

	// post
	@RequestMapping(value = "/loans", method = RequestMethod.POST)
	public Response insertLoan(@RequestBody LoanInput loanInput, HttpServletRequest request) {
		Response response = new Response();

		try {

			loanService.insertLoan(loanInput.getLoanId(), loanInput.getDate(), loanInput.getId_borrower(),
					loanInput.getId_book());
			response.setSuccess(true);
		} catch (Exception e) {
			response.setSuccess(false);
		}
		return response;
	}
	// patch

	@RequestMapping(value = "/loans/{loanId}", method = RequestMethod.PATCH)
	public Response updateLoan(@PathVariable("loanId") int loanId, @RequestBody LoanInput loanInput,
			HttpServletRequest request) {
		Response response = new Response();

		try {

			loanService.updateLoanRepo(loanInput.getLoanId(), loanInput.getDate(), loanInput.getId_borrower(),
					loanInput.getId_book());
			response.setSuccess(true);
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	// delete

	@RequestMapping(value = "/loans/{loanId}", method = RequestMethod.DELETE)
	public Response deleteLoan(@PathVariable("loanId") int loanId, HttpServletRequest request) {
		Response response = new Response();

		try {

			loanService.deleteLoan(loanId);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setSuccess(false);
		}

		return response;
	}
}
