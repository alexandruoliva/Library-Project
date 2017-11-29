package ro.training.structuri;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique = true, name = "LoanId")
	private int loanId;
	@Column(name = "date")
	private String date;


	/**
	 * @param loanId
	 * @param date
	
	 */
	public Loan(int loanId, String date, int idBorrower, int idBook) {
		super();
		this.loanId = loanId;
		this.date = date;
	
	}

	public Loan() {

	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	@ManyToOne
	@JoinColumn(name="idBorrower")
	private Borrower borrower;
	@ManyToOne
	@JoinColumn(name="idBook")
	private Book book;
	
}
