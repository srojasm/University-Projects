import java.util.*;

class Point2D extends Point
{
	double x;
	double y;

	public void Read(Scanner scanner)
	{	
		this.x = x;
		this.y = y;
		
		// read the original Read() function from Point 
		super.Read(scanner);

		// have the user enter x and y coordinates and assign them to the "x" and "y" field
		System.out.print("Enter X: ");
		x = scanner.nextDouble();
		System.out.print("Enter Y: ");
		y = scanner.nextDouble();
		scanner.nextLine();
	}

	public void Print()
	{
		// invoke the Print() function from Point
		super.Print();
		
		// print out what the x and y function are for that point
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}

	public int GetNumCoordinates()
	{
		// give the number of coordinates inputed
		return 2;
	}	

	public double GetDistance(Point2D B)
	{
		// find the distance between the two points using the formula
		double distance = Math.sqrt(((B.x-x)*(B.x-x))+((B.y-y)*(B.y-y)));
		return distance;		
	}
}
