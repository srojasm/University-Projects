class Node
{
	// public reference to next node
	public Node next;
	
	// Private data field
	Object data;

	public Node(Object data)
	{
		this.data = data;
	}

	public Object GetData()
	{
		return data;
	}
}
