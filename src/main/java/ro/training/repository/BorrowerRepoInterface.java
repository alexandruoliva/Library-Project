package ro.training.repository;

import java.util.List;

import ro.training.exceptions.DAOException;
import ro.training.structuri.Borrower;

public interface BorrowerRepoInterface {

	public List<Borrower> listBorrowers();

	public int insertBorrower(Borrower borrower);

	public void deleteBorrower(int borrowerId)throws DAOException ;

	public void updateBorrower(Borrower borrower) throws DAOException;

	public Borrower findBorrowerById(int borrowerId) ;
	
	public Borrower findBorrowerByName(String name) throws DAOException;
}

