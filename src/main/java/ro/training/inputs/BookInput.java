package ro.training.inputs;

public class BookInput {
	private int bookId;
	private String Author;
	private String Title;
	private String Description;
	private String Subject;
	private int YearPublished;
	private String borrowed;

	/**
	 * @param bookId
	 * @param author
	 * @param title
	 * @param description
	 * @param subject
	 * @param yearPublished
	 */
	public BookInput(int bookId, String author, String title, String description, String subject, int yearPublished, String borrowed) {
		super();
		this.bookId = bookId;
		this.Author = author;
		this.Title = title;
		this.Description = description;
		this.Subject = subject;
		this.YearPublished = yearPublished;
		this.borrowed= borrowed;
	}

	public BookInput() {

	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getSubject() {
		return Subject;
	}

	public String getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(String borrowed) {
		this.borrowed = borrowed;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	

	public int getYearPublished() {
		return YearPublished;
	}

	public void setYearPublished(int yearPublished) {
		YearPublished = yearPublished;
	}

}
