import java.util.Scanner;

public class Practice {

public static void main(String[]args){
	System.out.println("Hello World!");
	Scanner keyboard = new Scanner(System.in);
	int x = keyboard.nextInt();
	keyboard.nextLine();
	String y = keyboard.nextLine();
	while(keyboard.hasNext()){
		System.out.println("Int: " + x + " String: " + y);
	}
}
	

}
