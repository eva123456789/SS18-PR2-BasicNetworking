package networking.objects;

public class Address {

	private String firstname;
	private String lastname;
	private String mobileNumber;
	private String email;
	
	public Address(String firstname, String lastname, String mobileNumber, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//NOTE: this method helps to build the CSV line from the class
	public String toCSVString(String separator) {
		return firstname+separator
				+lastname+separator
				+mobileNumber+separator
				+email+separator;
	}

	@Override
	public String toString() {
		return "Address [firstname=" + firstname + ", lastname=" + lastname + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + "]";
	}
	
}
