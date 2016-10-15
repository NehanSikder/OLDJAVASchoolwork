import java.util.ArrayList;
import java.util.Collections;

public class Student implements Comparable {
	
	private int GPA;
	private String name;
	

	public Student(int GPA, String name) {
		this.GPA = GPA;
		this.name = name;
	}


	public static void main(String[] args) {
		Student x = new Student (4, "Sikder, Nehan");
		Student y = new Student (4, "Miller, Scott");
		Student z = new Student (0, "Cassar, Sean");
		ArrayList<Student> students = new ArrayList();
		students.add(x);
		students.add(y);
		students.add(z);
		System.out.println(students.toString());
		Collections.sort(students);
		System.out.println(students.toString());
	}

	@Override
	public String toString() {
		return "Student [GPA=" + GPA + ", name=" + name + "]";
	}


	@Override
	public int compareTo(Object o) {
	Student s = (Student) o;
	if (this.GPA > s.GPA){
		return -1;
	} else if (this.GPA < s.GPA) {
		return 1;
	} else {
		return 0;
	}
	
	}

}
