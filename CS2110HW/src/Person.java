import java.util.ArrayList;

//Arham Sikder ans2ur, Homework 0

public class Person {

	private String name;
	private int id;
	private ArrayList<Book> read;

	public Person(String name, int id) {
		this.name = name;
		this.id = id;
		this.read = new ArrayList<Book>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Book> getRead() {
		return read;
	}

	public boolean addBook(Book b) {
		if (this.read.contains(b)) {
			return false;
		} else {
			this.read.add(b);
			return true;
		}
	}

	public boolean hasRead(Book b) {
		return this.read.contains(b);
	}

	public boolean forgetBook(Book b) {
		if (this.read.contains(b)) {
			this.read.remove(b);
			return true;
		} else {
			return false;
		}
	}

	public int numBooksRead() {
		return this.read.size();
	}

	public boolean equals(Object o) {
		if (o instanceof Person) {
			Person p = (Person) o; // cast o to be the type book
			// compare to the actual fields
			return (this.id == p.id);
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Person [name= " + name + ", id= " + id + ", read= " + read + "]";
	}

	public static ArrayList<Book> commonBooks(Person a, Person b) {
		ArrayList<Book> common = new ArrayList<Book>();
		for (int i = 0; i < b.read.size(); i++) {
			if (a.read.contains(b.read.get(i))) {
				common.add(b.read.get(i));
			}
		}
		return common;
	}

	public static double similarity(Person a, Person b) {
		double similarity = 0.0;
		double common = Person.commonBooks(a, b).size();
		if (a.numBooksRead() < b.numBooksRead()){
			similarity = common / a.numBooksRead();
		} else {
			similarity = common / b.numBooksRead();	
		}
		return similarity;
	}

	public static void main(String[] args) {
		Person p = new Person("Nehan", 0);
		Person x = new Person("Nehan", 0);
		Person y = new Person("Bob", 1);
		System.out.println(p.getName());
		System.out.println(p.getId());
		System.out.println(p.getName());
		Book b = new Book("HP", "JK");
		Book c = new Book("AG", "DB");
		Book a = new Book("CMC", "D");
		System.out.println(p.addBook(b));
		System.out.println(p.addBook(c));
		System.out.println(p.hasRead(a));
		System.out.println(p.forgetBook(b));
		System.out.println(p.hasRead(b));
		System.out.println(p.numBooksRead());
		System.out.println(p.equals(x)); 
		System.out.println(p.equals(y));
		System.out.println(p.toString());
		
		Person nehan = new Person("nehan", 1);
		nehan.addBook(a);
		nehan.addBook(b);
		nehan.addBook(c);
		Person f = new Person("a", 2);
		f.addBook(b);
		f.addBook(c);
		System.out.println("Nehan's read list " + nehan.getRead().toString());
		System.out.println("F's read list " + f.getRead().toString());
		System.out.println("Commonbooks test" + Person.commonBooks(nehan, f).toString());
		

	}

}
