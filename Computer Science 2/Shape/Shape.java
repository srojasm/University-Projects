abstract class Shape implements Comparable
{
	String name;
	
	// constructor
	public Shape(String name)
	{
		this.name = name;
	}	

	// print the information about the shape
	public void Print()
	{
		System.out.println("Shape " + name);
	}	

	// get the area of the specific shape
	public abstract double GetArea();

	// compare the areas of the shapes 
	public int compareTo(Object other)
	{
		// compare the shape to another shape passed as the argument
		Shape other_shape = (Shape) other;
		
		double this_area = GetArea();
		double other_area = other_shape.GetArea();

		// return -1 if the other area is more than the original area
		if (this_area < other_area)
			return -1;

		// return 1 if the area is less than the other area
		else if (this_area > other_area)
			return 1;

		// if they are equal, return 0
		else
			return 0;	
	}
}
