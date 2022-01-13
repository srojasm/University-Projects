import java.util.ArrayList;

class LinkedList
{
	Node head;
	Node current;
	Node previous;
	int length;

	public void LinkedList()
	{
		// have length be equal to 0 before any list insertion
		length = 0;
	}

	// return the data associated with the current element or null if the current
	// element is past-the-end
	public Object Get()
	{
		return current == null ? null : current.GetData();
	}

	// go to the first element in the list
	public void Head()
	{
		current = head;
		previous = null;	
	}

	// go to the next element if the current element is not past-the-end
	public void Next()
	{
		if (current != null)
		{
			previous = current;
			current = current.next;
		}
	}

	// Insert a new element before the current element
	// or at the end if the current element is past-the-end
	public void Insert(Object data)
	{
		// create new node
		Node node = new Node(data);

		// set "next" reference of the new node
		node.next = current;

		// set "next" reference for previous node and treat the special case
		// where the current node is the head of the list
		if (current == head)
			head = node;
		else
			previous.next = node;

		// update current node
		current = node;

		// add one to the length of the list
		length += 1;
	}

	// remove the current element in the list and set the current element to 
	// the following element
	public void Remove()
	{
		// past-the-end is an invalid position for this operation
		if (current == null)
			throw new RuntimeException("Invalid position to remove");

		// remove element. consider special case where the current element
		// is the head
		if (current == head)
			head = current.next;
		else
			previous.next = current.next;

		// update current element 
		current = current.next;	

		// subtract one from the length
		length -= 1;
	}
	
	public void Print()
	{
		// traverse list
		for (Head(); Get() != null; Next())
			System.out.println(Get());
	}
	
	// sort the linked list
	public void Sort()
	{
		// set the current node as the head for removal and then insertion
		Head();

		// create a list with the length of the linked list
		ArrayList list = new ArrayList(length);
		
		// add the data of nodes into the list and remove them from the
		// linked list until the linked list is empty
		while(length > 0)
		{
			// save the data in each node as a comparable variable
			Comparable data = (Comparable) Get();
			// add the data to the list
			list.add(data);
			// remove the node from the list
			Remove();
		}
		
		// traverse the list
		for (int i = 0; i < list.size(); i++)
		{
			// set the smallest index to the current i in the list
			int min_index = i;

			// traverse the list starting at i
			for(int p = i; p < list.size(); p++)
			{
				// save the data in the current index and in the 
				// minimum index
				Comparable current = (Comparable)list.get(p);
				Comparable min_index_object = (Comparable)list.get(min_index);
	
				// if the current index holds a smaller value
				// update the smallest index
				if (current.compareTo(min_index_object) < 0)
					min_index = p;  
			}

			// save the data in the smallest index in a temporary vaariable
			Object temp = list.get(min_index);

			// swap the data at i with the data in the smallest variable
			list.set(min_index,list.get(i));
			list.set(i,temp);
		}

		for (int i = 0; i < list.size(); i++)
		{
			// reinsert all the data into the linked list 
			Insert((Object)list.get(i));
			Next();
		}
	}	
}
