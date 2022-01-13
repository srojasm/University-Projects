import java.util.*;

class Test
{
	private static int Factorial(int n)
	{
		// find the factorial of the given number
		int number = n;
		while (n > 1)
		{	
			// subtract 1 from the given number and multiply
			// i.e. (n) * (n-1) * (n-2) ... etc.
			n = n - 1;
			number = number * (n);
		}

		// return the product		
		return number; 
	}
	
	public static void main(String args[])
	{
		// create a new scanner
		Scanner scanner = new Scanner(System.in);
		
		// have the user input a number
		System.out.print("Enter an integer: ");
		int num = scanner.nextInt();
		
		// use the factorial function to find the factorial
	 	int factorial = Factorial(num);

		// print the answer
		System.out.println("Factorial: " + factorial);		
	}
}
