class HashTable
{
	int size;
	int length;
	Node nodes[];

	// constants
	static final double max_load_factor = 0.7;
	static final int initial_size = 5;

	public HashTable()
	{
		size = initial_size;
		nodes = new Node[size];
	}

	// returns the data associated with a given key
	// or null if the key is not present in the hash table
	public Object Search(Comparable key)
	{
		// obtain index for the key
		int index = key.hashCode() % size;

		// traverse collision list
		for (Node node = nodes[index]; node != null; node = node.next)
			if (key.compareTo(node.key) == 0)
				return node.data;

		// not found
		return null;
	}

	// insert a pair key-data into the hash table
	public void Insert(Comparable key, Object data)
	{
		// check if the table must grow
		double load_factor = (double) length / size;
		if (load_factor >= max_load_factor)
			Grow();
		
		// create node
		Node node = new Node(key, data);

		// get index for the key
		int index = key.hashCode() % size;
		// insert node
		 node.next = nodes[index];
		 nodes[index] = node;

		// update length
		length++;
	}

	// grow the hash table
	// all nodes must be repositioned according to their new hash indices
	// based on the new table size
	void Grow()
	{
		// message
		System.out.println("Growing hash table");
	
		// save old nodes and table size
		int old_size = size;
		Node[] old_nodes = nodes;

		// create new table
		size = size * 2;
		length = 0;
		nodes = new Node[size];
	
		// traverse old nodes
		for (int i = 0; i < old_size; i++)
			for (Node node = old_nodes[i]; node != null; node = node.next)
				Insert(node.key, node.data);	
	}

	// remove the element with the given key from the hash table
	// if the given key is not present an exception is raised
	public void Remove(Comparable key)
	{
		// get index for key
		int index = key.hashCode() % size;

		// traverse collision list
		Node previous = null;
		Node node = nodes[index];
		while(node != null && node.key.compareTo(key) != 0 );
		{
			previous = node;
			node = node.next;
		}
		// --- CONTINUE ---	
	}

	public Object GetSuccessor(Comparable key)
	{
		// instantiate a node that's null
		Node successor = new Node(null,null);
		
		// traverse the table
		for (int i = 0; i < size; i++)
		{
			// traverse all the collision lists
			for (Node node = nodes[i]; node != null; node = node.next)
			{
				// set the successor node to the first node that is encountered that
				// has a key larger than the argument's key
				if(successor.key == null && node.key.compareTo(key) > 0)
					successor = node;
		
				// set the successor to any node that has a key larger than the 
				// key of the argument but smaller than the successor's key
				else if(node.key.compareTo(key) > 0 && node.key.compareTo(successor.key) < 0)
					successor = node;
			}
		}
		// return the successor
		return successor.data;
	}
}
