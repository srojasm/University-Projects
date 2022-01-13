import java.util.*;

class Palindrome
{
	static boolean IsPalindrome(String word)
	{	
		// if the word has a length of 1 or 0 return true 
		if (word.length() <= 1)
			return true;
		
		// if the first and last character are the same
		// implement recursion on the substring from the second letter to the second to last letter
		else if (word.charAt(0) == word.charAt(word.length() - 1))
			return IsPalindrome(word.substring(1, word.length() - 1));

		// otherwise return false
		else
			return false;
	}	

	public static void main(String args[])
	{
		//instantiate a scanner
		Scanner scanner = new Scanner(System.in);

		// have the user input a string
		System.out.print("Enter a string: ");
		String word = scanner.nextLine();

		// assign a boolean variable to the string that's gone through the function
		boolean b = IsPalindrome(word);

		// if the boolean is true then print the statement that says so
		if (b == true)
			System.out.println("The string is a palindrome");
	
		// if the boolean is false print a statement saying so
		else
			System.out.println("The string is not a palindrome");	
	} 
}
