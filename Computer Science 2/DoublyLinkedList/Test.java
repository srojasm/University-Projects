class Test
{
	public static void main(String args[])
	{
		// instantiate a doubly linked list
		DoublyLinkedList doubly_linked_list = new DoublyLinkedList();
		
		// insert a string into the head of the list three times
		doubly_linked_list.Insert("a");
		doubly_linked_list.Head();
		doubly_linked_list.Insert("b");
		doubly_linked_list.Head();
		doubly_linked_list.Insert("c");

		// make the second to last node the current node and insert "d" before
		doubly_linked_list.Tail();
		doubly_linked_list.Previous();
		doubly_linked_list.Insert("d");

		// make the surrent node past-the-end and insert "e" into the tail
		doubly_linked_list.Tail();
		doubly_linked_list.Next();
		doubly_linked_list.Insert("e");

		// print the data in all of the nodes 
		doubly_linked_list.Print();
	}
}

