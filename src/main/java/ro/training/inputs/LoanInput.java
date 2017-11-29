package ro.training.inputs;

public class LoanInput {
	private int loanId;
	private String date;
	private int id_book;
	private String id_borrower;

	public int getId_book() {
		return id_book;
	}

	public void setId_book(int id_book) {
		this.id_book = id_book;
	}

	public String getId_borrower() {
		return id_borrower;
	}

	public void setId_borrower(String id_borrower) {
		this.id_borrower = id_borrower;
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

	/**
	 * @param loanId
	 * @param date
	 */
	public LoanInput(int loanId, String date, int id_book, String id_borrower) {
		super();
		this.loanId = loanId;
		this.date = date;
		this.id_book=id_book;
		this.id_borrower=id_borrower;
	}

	public LoanInput() {

	}
}
