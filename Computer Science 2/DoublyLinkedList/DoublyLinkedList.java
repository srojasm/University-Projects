class DoublyLinkedList 
{
	// private fields of head, tail, and current
	Node head;
	Node tail;
	Node current;

	// make the first node the current node
	public void Head()
	{
		// make the previous node null
		current = head;
		current.previous = null;
	}

	// make the last node the current node
	public void Tail()
	{
		// make the next node null
		current = tail;
		current.next = null;
	}

	// move the current position one element forward
	public void Next()
	{
		// if the current element is past-the-end, do not go to the next element
		if (current != null)
		{
			current.previous = current;
			current = current.next;
		}
	}

	// move the current position one element back
	public void Previous()
	{
		// if the current element is the head, then do not move back one 
		// element
		if (current.previous != null)
		{
			current.next = current;
			current = current.previous;
		}
	}

	// return the data associated with the current node
	public Object Get()
	{
		return current == null ? null : current.GetData();
	}

	// insert an element before the current node
	public void Insert(Object data)
	{
		// instantiate a new node
		Node node = new Node(data);

		// if the current element is not past-the-end,
		// set the previous field of the new node as the previous node of current
		if (current != null)
			node.previous = current.previous;
		
		// if the current element is past-the-end,
		// make the previous field of the new node the tail
		else
			node.previous = tail;

		// make the next node after the new node the current node
		node.next = current;

		// if the current node is not past-the-end or the head,
		// make the node after the one previous to the current node the new node
		if (current != null && current != head)
			current.previous.next = node;

		// if the current node is the head,
		// then the new node becomes the head
		if (current == head)
			head = node;

		// if the current node is past-the-end,
		// the new node is in the field after the tail
		else
			tail.next = node;

		// if the current node is not past-the-end;
		// the new node becomes the node before the current node
		if (current != null)
			current.previous = node;

		// if the current node is past the end,
		// the new node becomes the tail
		else
			tail = node;
	
		// set the new node as the current node		
		current = node;
	}

	// print the data in each of the nodes starting at the head and going to the
	// next node until the node's data is equal to null
	public void Print()
	{
		for (Head(); Get() != null; Next())
			System.out.println(Get());
	}
}

