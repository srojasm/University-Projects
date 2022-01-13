class Rectangle extends Shape
{
	double width;
	double height;

	// constructor that takes the width and the height
	public Rectangle(String name, double width, double height)
	{
		super(name);
		this.width = width;
		this.height = height;
	}

	// print the information about the specific rectangle
	public void Print()
	{
		System.out.println("Rectangle with width of " + width + " and height of " + height);
		System.out.println("Area: " + GetArea());
	}

	// use the width and height to find the area of the rectangle
	public double GetArea()
	{
		return width * height;
	}
}
