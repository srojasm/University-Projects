class Vector
{
	Object items[];
	int length;
	int size;

	void Grow()
	{
		// double size
		size = size * 2;
		
		// allocate new array of items
		Object new_items[] = new Object[size];
		
		// copy old items to new array
		for (int i = 0; i < length; i++)
			new_items[i] = items[i];

		// discard old items
		items = new_items;

		// message
		// System.out.println("Growing capacity to " + size);
	}
		
	public Vector()
	{
		size = 2;
		items = new Object[2];
	}

	public void Print()
	{
		// message
		System.out.println("Content");

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
			Grow();
		
		// shift elements to the right by traversing the vector backwards
		for (int i = length - 1; i >= index; i--)
			items[i + 1] = items[i];
		
		// insert new element
		items[index] = item;

		// one more item
		length ++;
	
		// message
		// System.out.println("Inserted " + item);
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
		// System.out.println("removing " + items[index]);

		// shift elements
		for (int i = index + 1; i < length; i ++)
			items[i - 1] = items[i];

		// clear last element
		items[length - 1] = null;

		// one less element
		length --;	
	}

	public int GetLength()
	{
		// make the field length Read Only
		return length;
	}

	// return the element at position index or null if index is out of bounds
	public Object Get(int index)
	{
		return index >= 0 && index < length ? items[index] : null;	
	}
	
	public void Swap(int index1, int index2)
	{
		Object temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}
}
