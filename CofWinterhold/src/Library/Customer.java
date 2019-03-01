package Library;

public class Customer {
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String password;
	protected String birthDate;
	protected String city;
	protected String sex;
	protected int id;

	public Customer(int id, String firstName, String lastName, String email, String password, String birthDate,
			String city, String sex) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.city = city;
		this.sex = sex;
		this.id = id;
	}
	
	public Customer() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public String getCity() {
		return city;
	}

	public String getSex() {
		return sex;
	}

}
