package ro.training.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ro.training.exceptions.DAOException;
import ro.training.structuri.Borrower;


@Repository
public class BorrowerRepo implements BorrowerRepoInterface {

	@PersistenceContext
	EntityManager em;

	
	public List<Borrower> listBorrowers() {
		return em.createQuery("FROM Borrower b", Borrower.class).getResultList();

	}

	public int   insertBorrower(Borrower borrower) {
		em.persist(borrower);
		em.flush();
		return borrower.getBorrowerId();
	}
@Override
	public void deleteBorrower(int borrowerId) throws DAOException  {

		Borrower borrower  = em.find(Borrower.class, borrowerId);
		if (borrower!= null) {
			em.remove(borrower);
		} else {
			throw new DAOException("Borrower with id : " + borrowerId+ " not found");
		}
	}

	public void updateBorrower(Borrower borrower) throws DAOException {
		int borrowerId = borrower.getBorrowerId();

		Borrower foundBorrower = em.find(Borrower.class, borrowerId);
		if (foundBorrower != null) {
			foundBorrower.setPassword(borrower.getPassword());
			foundBorrower.setAdress(borrower.getAdress());
			foundBorrower.setCity(borrower.getCity());
			foundBorrower.setEmail(borrower.getEmail());
			foundBorrower.setName(borrower.getName());
			foundBorrower.setPhoneNo(borrower.getPhoneNo());
		
		
			em.merge(foundBorrower);
		} else {
			throw new DAOException("Borrower not found [id " + borrowerId + "]");
		}
		em.merge(borrower);
	}
	@Override
	public Borrower findBorrowerById(int borrowerId) {

		Borrower borrower = em.find(Borrower.class, borrowerId);
		return borrower;
	}
	
	@Override
	public Borrower findBorrowerByName(String  Name) throws DAOException {

		TypedQuery<Borrower> query = em.createQuery("FROM Borrower b WHERE b.Name = :name", Borrower.class);
		query.setParameter("name", Name);

		return query.getSingleResult();
	}

	

	

	


}
