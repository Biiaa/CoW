package Library;

public class Student extends Customer{
		
	String profile;

	public Student () {
		
	}
	public Student(int id, String firstName, String lastName, String email, String password, String birthDate, String city,
			String sex,String profile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.city = city;
		this.sex = sex;
		this.id = id;
		this.profile = profile;
	}
	public String getFirstName() {
		return firstName;
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
	
	public String getProfile() {
		return profile;
	}
}
