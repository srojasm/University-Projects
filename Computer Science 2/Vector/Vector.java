class Vector
{
	Object items[];
	int length;
	int size;

	// choose a specific new size for the vector to grow to
	void Resize(int new_size)
	{
		// double size
		size = new_size;
		
		// allocate new array of items
		Object new_items[] = new Object[size];
		
		// copy old items to new array
		for (int i = 0; i < length; i++)
			new_items[i] = items[i];

		// discard old items
		items = new_items;

		// message
		System.out.println("Growing capacity to " + size);
	}
		
	public Vector()
	{
		size = 2;
		items = new Object[2];
	}

	public void Print()
	{	
		// message
		System.out.println("\nContent:");

		// traverse
		for (int i = 0; i < length; i++)
			System.out.println(items[i]);
	}
		
	public void Insert(int index, Object item)
	{
		// check index
		if (index < 0 || index > length)
		{
			System.out.println("invalid index");
			return;
		}

		// grow if necessary
		if (length == size)
			Resize(size + 1);

		// shift elements to the right by traversing the vector backwards
		for (int i = length - 1; i >= index; i--)
			items[i + 1] = items[i];

		// insert new element
		items[index] = item;

		// one more time
		length ++;

		// message
		System.out.println("Inserted " + item);
	}

	public void Add(Object item)
	{
		Insert(length, item);
	}		

	public void Remove(int index)
	{
		// check index
		if (index < 0 || index >= length)
		{
			System.out.println("invalid index");
			return;
		}
		
		// message
		System.out.println("removing " + items[index]);

		// shift elements
		for (int i = index + 1; i < length; i++)
			items[i - 1] = items[i];

		// clear last element
		items[length - 1] = null;

		// one less element
		length --;

		// if length will become less than half the size then make the size half
		// but if the size will be 1 after shrinking then do not resize
		if (length < size/2 && size > 2)
		{
			Resize(size/2);
		}
	}

	public int GetLength()
	{
		// make the field length Read Only
		return length;
	}
	
	// return the element at position index or null if index is out of bounds
	public Object Get(int index)
	{
		return index >= 0 && index < index ? items[index] : null;
	}

	public void Swap(int index1, int index2)
	{
		Object temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}
}
