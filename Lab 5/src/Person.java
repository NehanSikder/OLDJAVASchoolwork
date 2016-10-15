
public class Person implements Comparable<Person> {
	protected String name;
	protected String homeAddress;
	
	public Person(String name, String address) {
		this.name = name;
		this.homeAddress = address;
	}

	// best if classes that will be used as superclasses have a default constructor
	public Person() {
		this.name = "?";
		this.homeAddress = "?";
	}

	public String getMailingAddress() {
		return homeAddress;
	}
	
	public String toString() {
		return "{Person: name=" + name + ", homeAddress=" + homeAddress + "|";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return homeAddress;
	}

	public void setAddress(String address) {
		this.homeAddress = address;
	}

	public static void main(String[] args) {
		Person p1 = new Person("p1", "addr1");
		System.out.println(p1);
	}
//Ask TA
	@Override
	public int compareTo(Person o) {
		int retValue = 0;
		retValue = this.name.compareTo(o.name);
		return retValue;
	}
	
	public boolean equals(Object p){
		if (p instanceof Person){
		this.name.equals(((Person) p).name);
		return true;
		} else {
			return false;
		}
	}

}
