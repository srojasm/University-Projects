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
	public Object Search(Object key)
	{
		// obtain index for the key
		int index = key.hashCode() % size;

		// traverse collision list
		for (Node node = nodes[index]; node != null; node = node.next)
			if (node.key.equals(key))
				return node.data;

		// not found
		return null;
	}

	// insert a pair key-data into the hash table
	public void Insert(Object key, Object data)
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
	public void Remove(Object key)
	{
		// get index for key
		int index = key.hashCode() % size;

		// traverse collision list
		Node previous = null;
		Node node = nodes[index];
		while(node != null && !node.key.equals(key));
		{
			previous = node;
			node = node.next;
		}	
		
		// not found
		if (node == null)
			throw new RuntimeException("Key not found");
	
		// delete it
		if (previous == null)
			nodes[index] = node.next;
	
		else
			previous.next = node.next;

		// update length
		length--;
	}

	// return the integer value representing the longest collision list in
	// the hash table, given in number of nodes
	public int GetLongestChain()
	{
		// create a variable for the longest chain set initially to 0
		int longest_chain = 0;

		// traverse the hash table
		for (int i = 0; i < size; i++)
		{
			// create a a variable to count the length of the each chain
			int chain = 0;

			// traverse the chain
			for (Node node = nodes[i]; node != null; node = node.next)
				chain += 1;

			// if the chain is longer than the longest chain
			// set this chain as the longest
			if (chain > longest_chain)
				longest_chain = chain;
		}

		// return the longest chain
		return longest_chain;
	}
}
