import java.util.*;

class TestPoint2D
{
	public static void main(String[] args)	
	{
		// instantiate a scanner 
		Scanner scanner = new Scanner(System.in);
	
		// create two points a and b of type Point2D
		Point2D a = new Point2D();
		Point2D b = new Point2D();
		
		// invoke the Read() on both of the points
		a.Read(scanner);
		b.Read(scanner);
		
		// invoke the Print() on both of the points
		a.Print();
		b.Print();

		// invoke GetNumCoordinates() on one of the points
		int num = a.GetNumCoordinates();
		System.out.println("Number of Coordinates: " + num);
		
		// invoke GetDisatance() on one of the points and use the other point as the argument
		double distance = a.GetDistance(b);
		System.out.println("Distance: " + distance);
	}
}
