package ro.training.structuri;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique = true, name = "bookId")
	private int bookId;

	@Column(name = "Author")
	private String author;
	@Column(name = "Title")
	private String title;
	@Column(name = "Description")
	private String description;
	@Column(name = "Subject")
	private String subject;
	@Column(name = "YearPublished")
	private int yearpublished;
	@Column(name="borrowed")
	private String borrowed;
	

	/**
	 * @param bookId
	 * @param author
	 * @param title
	 * @param description
	 * @param subject
	 * @param yearPublished
	 */
	public Book(int bookId, String author, String title, String description, String subject, int yearPublished,String  borrowed) {
		super();
		this.bookId = bookId;
		this.author = author;
		this.title = title;
		this.description = description;
		this.subject = subject;
		this.yearpublished = yearPublished;
		this.borrowed = borrowed;
		
		
	}

	public Book() {

	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getYearPublished() {
		return yearpublished;
	}

	public void setYearPublished(int yearPublished) {
		yearpublished = yearPublished;
	}

	public String getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(String borrowed) {
		this.borrowed = borrowed;
	}


	
	}



