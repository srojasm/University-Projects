class MergeSort
{
	static void Merge(int v[], int left1, int right1, int left2, int right2)
	{
		// Number of elements
		int n1 = right1 - left1 + 1;
		int n2 = right2 - left2 + 1;
		
		// alocate sub arrays
		int v1[] = new int[n1];
		int v2[] = new int[n2];

		// copy first sub array
		for (int i = 0; i < n1; i++)
			v1[i] = v[left1 + i];

		// copy second sub array
		for (int i = 0; i < n2; i++)
			v2[i] = v[left2 + i];

		// indices 
		int index = left1;
		int index1 = 0;
		int index2 = 0;

		// merge
		while (true)
		{
			// check for empty sub arrays
			boolean empty1 = index1 == n1;
			boolean empty2 = index2 == n2;

			// if both are empty, done
			if (empty1 && empty2)
				break;

			// condiiton to grab element from first sub array
			//
			// a) second subarray is empty, or 
			//
			// b) first sub array is not empty and its current element is less than the current element in the second subarray
			//
			if (empty2 || (!empty1 && v1[index1] < v2[index2]))
			{
				// grab element from first sub array
				v[index] = v1[index1];
				index1 ++;	
			}

			else
			{
				// grap element from second sub array
				v[index] = v2[index2];
				index2 ++;
			}
			// go to next element in merged array
			index ++;
		}
	}
	
	static void Sort(int v[], int left, int right)
	{
		// arrays with 0 or 1 element are already sorted
		if (left >= right)
			return;
		
		// middle point
		int middle = (left + right ) / 2;

		// sort recursively
		Sort(v, left, middle);
		Sort(v, middle + 1, right);

		// merge 
		Merge(v, left, middle, middle + 1, right);
	}
	
	public static void Sort(int v[])
	{
		Sort(v, 0 , v.length - 1);
	}
	
}
