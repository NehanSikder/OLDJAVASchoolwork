
public class Student extends Person {
	
	private String campusAddress;
	private double gpa;
	
	public Student(String name, String address, String campAd) {
		super(name, address);
		this.campusAddress = campAd;
		this.gpa = 0.0;
	}



	@Override
	public String toString() {
		return "Student [campusAddress=" + campusAddress + ", name=" + name + ", homeAddress=" + homeAddress + "]";
	}



	public static void main(String[] args) {

	}

}
