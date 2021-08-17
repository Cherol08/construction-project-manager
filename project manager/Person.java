
public class Person {
	// person instance variables
	String name, surname;
	String userType;
	String telephoneNum;
	String email;
	String physicalAdd;

	// person object constructor
	public Person(String name, String surname, String userType, String telephoneNum, String email, String physicalAdd) {
		this.name = name;
		this.surname = surname;
		this.userType = userType;
		this.telephoneNum = telephoneNum;
		this.email = email;
		this.physicalAdd = physicalAdd;
	}

	// method returns compiled object/person info
	public String PersonDetails() {
		String personInfo = userType + "\nName: " + name + " " + surname + "\nTelephone Number: " + telephoneNum
				+ "\nEmail address: " + email + "\nPhysical Address: " + physicalAdd;

		return personInfo;
	}

}
