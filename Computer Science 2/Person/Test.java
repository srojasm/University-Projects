import java.util.*;

class Test
{
	public static void main(String args[])
	{
		// create a scanner to take keyboard inputs
		Scanner scanner = new Scanner(System.in);
		
		// user input of name and assign to object 
		System.out.print("Enter name: ");
		String name = scanner.nextLine();

		// user input of age and assign to object
		System.out.print("Enter age: ");
		int age = scanner.nextInt();

		//instantiate Person 
		Person person = new Person(name,age);
	
		// print the name and age
		person.Print();

		// determine whether the person is underage and print
		boolean underage = person.IsUnderage();
		System.out.print("\nUnderage: " + underage + "\n");
	}
}
