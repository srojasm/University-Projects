class Node
{
	// public fields of previous and next 
	// private field of data
	public Node previous;
	public Node next;
	Object data;
	
	// create the constructor
	public Node(Object data)
	{
		this.data = data;
	}

	// create a function that returns the data
	public Object GetData()
	{
		return data;
	}
}

