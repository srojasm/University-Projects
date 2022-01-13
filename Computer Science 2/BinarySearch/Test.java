class Test
{
	public static void main(String args[])
	{
		// instantiate 3 trees
		BinarySearchTree tree1 = new BinarySearchTree();
		BinarySearchTree tree2 = new BinarySearchTree();
		BinarySearchTree tree3 = new BinarySearchTree();

		// add keys and data to tree 1
		tree1.Insert(5,null);
		tree1.Insert(2,null);
		tree1.Insert(8,null);
		tree1.Insert(1,null);
		tree1.Insert(3,null);
		tree1.Insert(7,null);
		tree1.Insert(10,null);
		
		// print height of tree 1
		System.out.println("Height of Tree 1: " + tree1.GetHeight());

		// add keys and data to tree 2
		tree2.Insert(8,null);
		tree2.Insert(7,null);
		tree2.Insert(10,null);
		tree2.Insert(5,null);
		tree2.Insert(2,null);
		tree2.Insert(1,null);
		tree2.Insert(3,null);
		
		// print height of tree 2
		System.out.println("Height of Tree 2: " + tree2.GetHeight());

		// add keys and data to tree 3
		tree3.Insert(1,null);
		tree3.Insert(3,null);
		tree3.Insert(2,null);
		tree3.Insert(5,null);
		tree3.Insert(7,null);
		tree3.Insert(8,null);
		tree3.Insert(10,null);
		
		// print height of tree 3
		System.out.println("Height of Tree 3: " + tree3.GetHeight());
	}
}
