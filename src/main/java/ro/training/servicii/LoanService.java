package ro.training.servicii;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.training.exceptions.*;
import ro.training.repository.*;
import ro.training.structuri.*;

@Service
public class LoanService {
	@Autowired
	private LoanRepo loanRepo;

	public LoanRepo getLoanRepository() {
		return loanRepo;
	}

	public void loanRepo(LoanRepo loanRepo) {
		this.loanRepo = loanRepo;
	}

	@Transactional
	public void insertLoan(int loanId, String date,String idBorrower, int idBook)
			throws DAOException {
		Loan loan = new Loan();
      //legatura de many to one 
		loan.setLoanId(loanId);
		loan.setDate(date);
		
		//Borrower borrower = new Borrower
		
		//borrwer.setborrwerid(idborrower);
		
		
	

		loanRepo.insertLoan(loan);
	}

	

	@Transactional
	public void deleteLoan(int loanId) throws DAOException {
		loanRepo.deleteLoan(loanId);
	}

	@Transactional
	public void updateLoanRepo(int loanId, String date, String idBorrower, int idBook)
			throws DAOException {
		Loan loan = new Loan();
	
				
				loan.setLoanId(loanId);
				loan.setDate(date);
			

				loanRepo.updateLoan(loan);
	}

	@Transactional
	public List<Loan> listAllLoans() {
		return loanRepo.listLoans();
	}

	@Transactional
	public Loan getLoanById(int loanId) {
		return loanRepo.findLoanById(loanId);
	}
}