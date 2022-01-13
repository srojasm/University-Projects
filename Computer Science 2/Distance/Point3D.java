import java.util.*;
class Point3D extends Point
{
	double x;
	double y;
	double z;

	public void Read(Scanner scanner)
	{
		// invoke the Read() function from Point
		super.Read(scanner);

		this.x = x;
		this.y = y;
		this.z = z;

		// have the user input x, y, and z and assign them to their respective fields
		System.out.print("Enter X: ");
		x = scanner.nextDouble();
		System.out.print("Enter Y: ");
		y = scanner.nextDouble();
		System.out.print("Enter Z: ");
		z = scanner.nextDouble();	
		scanner.nextLine();
	}
	
	public void Print()
	{
		// invoke Print() from Point
		super.Print();

		// print the values of x, y, and z
		System.out.println("x = " + x + "\ny = " + y + "\nz = " + z);
	}

	public int GetNumCoordinates()
	{
		// return the amount of coordinates that were inputed
		return 2;
	}

	public double GetDistance(Point3D a)
	{
		// find the distance between the 2 points using the formula
		double distance = Math.sqrt(((a.x-x)*(a.x-x))+((a.y-y)*(a.y-y))+((a.z-z)*(a.z-z)));	
		return distance;
	}
}
