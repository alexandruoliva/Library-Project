package ro.training.servicii;


import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

import ro.training.exceptions.DAOException;
import ro.training.repository.*;

import ro.training.structuri.Borrower;


@Service
public class BorrowerService {
	@Autowired
	private BorrowerRepo borrowerRepo;

	public BorrowerRepo getBorrowerRepository()  {
		return borrowerRepo;
	}

	public void borrowerRepo(BorrowerRepo borrowerRepo) {
		this.borrowerRepo= borrowerRepo;
	}

	@Transactional
	public void insertBorrower( String password, String name, String adress, String city , String email ,String phoneNo)
			throws DAOException {
		
		Borrower borrower= new Borrower();
		
	
		borrower.setPassword(password);
		borrower.setName(name);
		borrower.setAdress(adress);
		borrower.setCity(city);
		borrower.setEmail(email);
		borrower.setPhoneNo(phoneNo);
		
	
		borrowerRepo.insertBorrower(borrower);
	}

	@Transactional
	public void deleteBorrower(int borrowerId) throws DAOException {
		borrowerRepo.deleteBorrower(borrowerId);
	
	}
	

	

	@Transactional
	public void updateBorrower(int borrowerId,String password, String name, String adress, String city , String email ,String phoneNo) throws DAOException {
		Borrower borrower =new Borrower();

		// Role role = new Role();
		
		borrower.setPassword(password);
		borrower.setName(name);
		borrower.setAdress(adress);
		borrower.setCity(city);
		borrower.setEmail(email);
		borrower.setPhoneNo(phoneNo);
		borrower.setBorrowerId(borrowerId);
		
		borrowerRepo.updateBorrower(borrower);

	}

	@Transactional
	public Borrower findBorrowerById(int borrowerId) throws DAOException {
		return borrowerRepo.findBorrowerById(borrowerId);
	}
	
	@Transactional
	public List<Borrower> listAllBorrowers() {
		return borrowerRepo.listBorrowers();
	}

}
