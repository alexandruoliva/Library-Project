package ro.training.structuri;



import javax.persistence.*;

@Entity
@Table(name = "borrower")
public class Borrower {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique = true, name = "borrowerId")

	private int borrowerId;
	@Column(name = "password")
	private String password;

	/**
	 * @param borrowerId
	 * @param password
	 * @param name
	 * @param adress
	 * @param city
	 * @param email
	 * @param phoneNo
	 */
	public Borrower(int  borrowerId, String password, String name, String adress, String city, String email,
			String phoneNo) {
		super();
		this.borrowerId = borrowerId;
		this.password = password;
		this.name = name;
		this.adress = adress;
		this.city = city;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public Borrower() {

	}

	@Column(name = "name")
	private String name;
	@Column(name = "adress")
	private String adress;
	@Column(name = "city")
	private String city;
	@Column(name = "email")
	private String email;
	@Column(name = "phoneNo")
	private String phoneNo;

	public int getBorrowerId() {
		return borrowerId;
	}

	/**
	 * @param borrowerId
	 * @param name
	 * @param adress
	 * @param city
	 * @param email
	 * @param phoneNo
	 */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
