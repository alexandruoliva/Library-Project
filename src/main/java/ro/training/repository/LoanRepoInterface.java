package ro.training.repository;

import java.util.List;

import ro.training.exceptions.*;
import ro.training.structuri.*;




public interface LoanRepoInterface {

	public List<Loan> listLoans();

	public int insertLoan(Loan loan);

	public void deleteLoan(int loanId) throws DAOException;

	public void updateLoan(Loan loan) throws DAOException;

	public Loan findLoanById(int loanId);

	public Loan findLoanbyBorrowersId(int idBorrower );
	
	public Loan findLoanByBookId(int idBook);
}
