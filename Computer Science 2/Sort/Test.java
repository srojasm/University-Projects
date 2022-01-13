import java.util.*;
class Test
{
	public static void main(String args[])
	{
		// instantiate random
		Random random = new Random();

		// read argument algorithm from args[0]
		String algorithm = args[0];

		// read argument size from args[1]
		int size = Integer.parseInt(args[1]);
		
		// create and array of size elements
		int v[] = new int[size];
	
		// for every element in the array
		// use a for loop to initialize all elements with random values
		for (int i = 0; i < v.length; i++)
		{
			v[i] = random.nextInt();
		}

		// if the algorithm is selection
		// sort through selection sort
		if (algorithm.equals("selection"))
			SelectionSort.Sort(v);

		// otherwise use merge sort
		else if (algorithm.equals("merge"))
			MergeSort.Sort(v);
	}
}
