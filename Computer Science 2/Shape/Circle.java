class Circle extends Shape
{
	double radius;
	
	// constructor circle which takes the radius
	public Circle(String name, double radius)
	{
		super(name);
		this.radius = radius;
	}

	// print the information about the circle
	public void Print()
	{
		System.out.println("Circle with radius of " + radius); 
		System.out.println("Area: " + GetArea());
	}

	// find the area of the circle using the given radius
	public double GetArea()
	{
		return Math.PI * radius * radius;
	}
}
