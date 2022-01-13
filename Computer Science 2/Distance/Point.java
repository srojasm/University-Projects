import java.util.*;

abstract class Point
{
	String name;
	
	public void Print()
	{
		// print the "point NAME" with the name that is entered	
		System.out.println("Point " + name);
	}

	// Read() function where the argument is of type Scanner
	public void Read(Scanner scanner)
	{
		// have the user input the name of the point
		System.out.print("Enter name: ");
		String name = scanner.nextLine();
		this.name = name;
	}
	
	// abstract function that will say the amount of coordinates
	public abstract int GetNumCoordinates();
}
