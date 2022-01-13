class Heap
{
	Vector vector;
	
	int Parent(int index)
	{
		return (index - 1) / 2;
	}

	int Left(int index)
	{
		return index * 2 + 1;
	}

	int Right(int index)
	{
		return index * 2 + 2;
	}

	public Heap()
	{	
		vector = new Vector();
	}	
		
	public int GetLength()
	{
		return vector.GetLength();
	}

	public Comparable Get(int index)
	{
		return (Comparable) vector.Get(index);
	}

	void Sink(int index)
	{
		// Get left and right indexes
		int left = Left(index);
		int right = Right(index);

		// assume maximum value is the current node
		int max_index = index;

		// update max to left child if necessary
		if (left < GetLength() && Get(left).compareTo(Get(max_index)) > 0)
			max_index = left;

		// update max to right child if necessary
		if (right < GetLength() && Get(right).compareTo(Get(max_index)) > 0)
			max_index = right;

		// check if max is not the current node
		if (max_index != index)
		{
			// swap elements and call recursively
			vector.Swap(index, max_index);
			Sink(max_index);
		}
	}

	void Float(int index)
	{
		// ignore if it's the root
		if (index == 0)
			return;

		// check if current item is greater than its parent
		int parent = Parent(index);
		if (Get(index).compareTo(Get(parent)) > 0)
		{
			vector.Swap(index, parent);
			Float(parent);
		}
	}

	public void Insert(Comparable item)
	{
		// add element at the end
		vector.Add(item);
		
		// float it
		Float(vector.GetLength() - 1);
	}

	public Comparable ExtractMax()
	{
		// check if there are any elements ledt in the heap
		if (GetLength() == 0)
			throw new RuntimeException("Heap is empty");
		
		// get root
		Comparable max_item = Get(0);

		// swap root and last time, then remove last item
		vector.Swap(0, GetLength() - 1);
		vector.Remove(GetLength() - 1);

		// sink root
		Sink(0);

		// return extracted element
		return max_item;

	}	
}
