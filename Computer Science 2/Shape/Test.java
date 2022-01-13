import java.util.*;
class Test
{
	// find the index of the smallest element
	static int GetMinIndex(Shape v[], int left, int right)
	{
		// by default pick the element that is the most to the left
		int min_index = left;

		// go through the array 
		for (int i = left + 1; i <= right; i++)
		{ 
			// compare the area of the element by the one in the minimum
			// index posiiton
			// if the element is smaller then it's position is the smallest
			// index
			if (v[i].compareTo(v[min_index]) == -1)
				min_index = i;
		}

		// return the index of the smallest element
		return min_index;
	}
	
	// swap the smallest element with the element in a smaller index/position
	static void Swap(Shape v[], int index1, int index2)
	{
		// create a temporary variable
		Shape temp = v[index1];
		v[index1] = v[index2];
		v[index2] = temp;
	}

	// sort the list
	static void Sort(Shape v[])
	{
		for (int i = 0; i < v.length - 1; i++)
		{
			// for every element in the array, compare it to every other
			//  element through the min_index function
			int min_index = GetMinIndex(v, i, v.length - 1);

			// swap its position
			Swap(v, min_index, i); 
		}
	}

	public static void main(String args[])
	{
		// create a scanner
		Scanner scanner = new Scanner(System.in);
	
		// have the user input how many shapes will be entered
		// save to a variable
		System.out.println("Enter a number of shapes: ");
		int N = scanner.nextInt();		
	
		// create an array with N number of empty element
		Shape v[];
		v = new Shape[N];
		
		// have the user input the information for every element
		for (int i = 0; i < v.length; i ++)
		{
			// ask the user whether the element is a circle or a rectangle
			System.out.println("\nWhat is the shape type (Circle or Rectangle): ");
			scanner.nextLine();	
			String name = scanner.nextLine();

			// if the shape is a circle ask
			if (name.equals("Circle") || name.equals("circle"))
				{
					// ask for the radius of the circle
					System.out.println("Enter the radius: ");
					double radius = scanner.nextDouble();

					// instantiate a circle with the given radius
					Circle circle = new Circle(name, radius);
				
					// save the specific circle to the array
					v[i] = circle;
				} 
			// if the shape is a rectangle
			else
				{	
					// ask the user for the width and height of the rectangle
					System.out.println("Enter the width: ");
					double width = scanner.nextDouble();
					System.out.println("Enter the height: ");
					double height = scanner.nextDouble();
	
					// instantiate a rectangle with the given dimensions
					Rectangle rectangle = new Rectangle(name, width, height);

					// save the specific rectangle to the array
					v[i] = rectangle;
				}
		}

		// sort the array created by user inputs
		Sort(v);
		
		// print the information of each of the elements in the sorted array 
		System.out.println("\nSorted by smallest area to the largest:\n");
		for (int i = 0; i < v.length; i ++)
		{
			v[i].Print();
			System.out.println("\n");		
		}	
			
	}
}
