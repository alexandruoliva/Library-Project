package ro.training.inputs;

public class BorrowerInput {
	private int borrowerId;
	private String password;
	private String name;
	private String adress;
	private String city;
	private String email;
	private String phoneNo;

	public int getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	/**
	 * @param borrowerId
	 * @param password
	 * @param name
	 * @param adress
	 * @param city
	 * @param email
	 * @param phoneNo
	 */
	public BorrowerInput(int borrowerId, String password, String name, String adress, String city, String email,
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
	public BorrowerInput(){
		
	}

	
}
