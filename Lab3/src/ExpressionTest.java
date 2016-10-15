
public class ExpressionTest {

	public static void main(String[] args) {
		
		
		for (int i = 0; i < 37; i ++){
			int whichVersion = i; // a number such that 0 <= whichVersion < 37
			String anExpression = "1 ** 3"; // a String that may or may not be an expression
			boolean valid = Expression.isValid(whichVersion, anExpression);
			System.out.println("#" + i + valid);
			
		}
		
		boolean valid = Expression.isValid(36, "5+4");

		System.out.println(valid);

	//36 doesn't recognize any operators
	// 8 doesn't recognize any operator 
	// 7 doesn't recognize any operator

	}

}
