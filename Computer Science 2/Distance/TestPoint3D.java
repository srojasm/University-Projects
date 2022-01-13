import java.util.*;

class TestPoint3D
{
	public static void main(String[] args)
	{
		// instantiate scanner
		Scanner scanner = new Scanner(System.in);

		// instantiate two points of type Point3D
		Point3D a = new Point3D();
		Point3D b = new Point3D();

		// invoke the Read() function on both points
		a.Read(scanner);
		b.Read(scanner);

		// invoke the Print() function on both points
		a.Print();
		b.Print();

		// invoke the GetNumCoordinates() to find the amount of coordinates inputed
		int num = a.GetNumCoordinates();
		System.out.println("Number of coordinates: " + num);
		
		// invoke the GetDistance() function on one of the points with the other point as the argument
		double distance = a.GetDistance(b);
		System.out.println("Distance: " + distance);
	}
}
