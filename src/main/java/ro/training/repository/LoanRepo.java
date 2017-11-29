package ro.training.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ro.training.exceptions.DAOException;
import ro.training.structuri.*;


@Repository
public class LoanRepo implements LoanRepoInterface {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Loan> listLoans() {
		return em.createQuery("FROM Loan u", Loan.class).getResultList();

	}

	@Override
	public int insertLoan(Loan loan) {
		em.persist(loan);
		em.flush();
		return loan.getLoanId();
	}

	@Override
	public void deleteLoan(int loanId) throws DAOException {

		Loan loan = em.find(Loan.class, loanId);
		if (loan != null) {
			em.remove(loan);
		} else {
			throw new DAOException("Loan with id : " + loanId + " not found");
		}
	}

	@Override
	public void updateLoan(Loan loan) throws DAOException {
		int loanId = loan.getLoanId();

		Loan foundLoan = em.find(Loan.class, loanId);
		if (foundLoan != null) {
			foundLoan.setDate(loan.getDate());
			foundLoan.setLoanId(loan.getLoanId());
			
			em.merge(foundLoan);
		} else {
			throw new DAOException("Loan not found [id " + loanId+ "]");
		}
		em.merge(loan);
	}

	@Override
	public Loan findLoanById(int loanId) {

		Loan loan = em.find(Loan.class, loanId);
		return loan;
	}

	@Override
	public Loan findLoanbyBorrowersId(int idBorrower) {

		TypedQuery<Loan> query = em.createQuery("FROM Loan u WHERE u.idBorrower = :idBorrower", Loan.class);
		query.setParameter("idBorrower", idBorrower);

		return query.getSingleResult();
	}
	
	@Override
	public Loan findLoanByBookId(int idBook){
		TypedQuery<Loan> query = em.createQuery("FROM Loan u WHERE u.idBook = :idBook", Loan.class);
		query.setParameter("idBook", idBook);

		return query.getSingleResult();
	}
}