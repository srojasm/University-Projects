class Test
{
	public static void main(String srgs[])
	{
		// create a linked list
		LinkedList linkedlist = new LinkedList();

		// insert integers to the linked list
		linkedlist.Insert(Integer.valueOf(20));
		linkedlist.Insert(Integer.valueOf(34));
		linkedlist.Insert(Integer.valueOf(12));
		linkedlist.Insert(Integer.valueOf(74));
		linkedlist.Insert(Integer.valueOf(43));
		linkedlist.Insert(Integer.valueOf(61));
		linkedlist.Insert(Integer.valueOf(83));
		linkedlist.Insert(Integer.valueOf(57));

		// sort the linked list
		linkedlist.Sort();

		// print the sorted list
		System.out.println("Sorted Linked List: ");
		linkedlist.Print();
	}
}
