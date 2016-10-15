import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;


public class PersonTests {

	@Test
	public void testPersonOnly() {
		Person p1 = new Person("Jane", "100 Main St, Somewhere");
		Person p2 = new Person("Raul", "27 Elm St, Elsewhere");
		
		assertEquals("toString", "{Person: name=Jane, homeAddress=100 Main St, Somewhere|", p1.toString());
		assertEquals("toString", "{Person: name=Raul, homeAddress=27 Elm St, Elsewhere|", p2.toString());
	}
	@Test
	public void testPersonEmployee() {
		ArrayList<Person> list = new ArrayList<Person>();
		Person p = new Person("Mai", "3156 Grove Rd, Somewhere");
		list.add(p);
		p = new Employee("Don", "6562 Trask Way, Elsewhere", "Front Desk", 2110);
		list.add(p);
		
		assertEquals("toString", "{Person: name=Mai, homeAddress=3156 Grove Rd, Somewhere|", list.get(0).toString());
		assertEquals("toString", "{Empl: n=Don, ha=6562 Trask Way, Elsewhere, wa=Front Desk, id=2110}", list.get(1).toString());
	}
	@Test
	public void testPersonEmployeeStudent() {
		ArrayList<Person> list = new ArrayList<Person>();
		Person p = new Person("Mai", "3156 Grove Rd, Somewhere");
		list.add(p);
		p = new Employee("Don", "6562 Trask Way, Elsewhere", "Front Desk", 2110);
		list.add(p);
		// TODO: uncomment the following
		 p = new Student("Dana Wahoo", "21 Wahoo Ave, NOVA", "1 JPA, CVille, VA");
		 list.add(p);
		
		assertEquals("toString", "{Person: name=Mai, homeAddress=3156 Grove Rd, Somewhere|", list.get(0).toString());
		assertEquals("toString", "{Empl: n=Don, ha=6562 Trask Way, Elsewhere, wa=Front Desk, id=2110}", list.get(1).toString());
		//fail("Implement student and fix the junit to test it.");
		assertEquals("toString", "Student [campusAddress=1 JPA, CVille, VA, name=Dana Wahoo, homeAddress=21 Wahoo Ave, NOVA]", list.get(2).toString()); // TODO: finish this
		for (Person x : list){
		assertTrue(x instanceof Comparable);
		
		ArrayList<Person> name = new ArrayList<Person>();
		Person a = new Person("Mai", "2000 Grove Rd, Somewhere");
		name.add(a);
		Person b = new Person("Alex", "1000 Grove Rd, Somewhere");
		name.add(b);
		// TODO: uncomment the following
		Person c = new Person("Ben", "3000 Grove Rd, Somewhere");
		name.add(c);
		System.out.println(name);
		Collections.sort(name, new comparebyaddess(){
		});
		System.out.println(name);

		}
	}

}
