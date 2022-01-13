class Node
{
	Comparable key;
	Object data;

	public Node parent;
	Node left;
	Node right;

	public Node(Comparable key, Object data)
	{
		this.key = key;
		this.data = data;
	}	

	public Comparable GetKey()
	{
		return key;
	}

	public Object GetData()
	{
		return data;
	}
}
