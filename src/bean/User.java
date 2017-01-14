package bean;

public class User {
	private String id;
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	public User(String i, String fn, String ln, String e, String pwd){
		id = i;
		firstName = fn;
		lastName = ln;
		email = e;
		password = pwd;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
