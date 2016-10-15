import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab1Scanner {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		int x = keyboard.nextInt();
		keyboard.nextLine();
		String y = keyboard.nextLine();
		while(keyboard.hasNext()){
			System.out.println("Int: " + x + " String: " + y);
		}
		/*
		File f = new File("data1.txt");
		try {
			Scanner read = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
		
		System.out.println("Bytes: " + f.getTotalSpace());
		System.out.println("Full name: " + f.getAbsolutePath());
	*/
	}
}
