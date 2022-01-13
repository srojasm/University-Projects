class BinarySearchTree
{
	Node root;

	// given a key, return the node containing that key
	// private auxilary function
	Node SearchNode(Comparable key)
	{
		// start at the root
		Node node = root;

		// traverse tree
		while (node != null)
		{
			// check if this is the ndoe we're looking for
			if (key.compareTo(node.key) == 0)
				return node;
		
			// chick if we should continue looking in the left or right subtree	
			else if (key.compareTo(node.key) < 0)
				node = node.left;

			else
				node = node.right;
		}
		
		// key not found
		return null;
	}

	// given a key, return the data associated with it
	public Object Search(Comparable key)
	{
		// find the node
		Node node = SearchNode(key);

		// return associated data or null
		return node == null ? null : node.GetData();
	}

	// return the node containing the minimum key in the subtree starting at the node
	// passed in the argument
	Node GetMinNode(Node node)
	{
		// go down the left node
		while (node != null && node.left != null)
			node = node.left;

		// return it
		return node;
	}

	// return the data associated with the minimum node
	public Object GetMin()
	{
		// get minimum node starting at the root
		Node node = GetMinNode(root);

		// return associated data or null
		return node == null ? null : node.GetData();
	}	

	// return successor node for the node pass as an argument
	// private auxilary function
	Node GetSuccessorNode(Node node)
	{
		// case 1 - node has a right child
		if (node.right != null)
			return GetMinNode(node.right);

		// case 2 - node has no right child
		Node parent = node.parent;

		while (parent != null && parent.left != node)
		{
			node = parent;
			parent = node.parent;
		}
		
		// return value of the parent node if we found a node that is the left
		// child of its parent or we reached the root
		return parent;
	}

	// return the successor data for the given key
	public Object GetSuccessor(Comparable key)
	{
		// find node
		Node node = SearchNode(key);
		
		if (node == null)
			return null;

		// get successor node
		node = GetSuccessorNode(node);
		
		// return associated data
		return node == null ? null : node.data;
	}	

	public void Insert(Comparable key, Object data)
	{
		// create node
		Node node = new Node(key, data);

		// walk down the tree
		Node parent = null;
		Node child = root;

		while (child != null)
		{
			// parent goes down
			parent = child;

			// child goes down
			if (key.compareTo(child.GetKey()) == 0)
				throw new RuntimeException("Duplicate key");
			
			else if (key.compareTo(child.GetKey()) < 0)
				child = child.left;

			else
				child = child.right;
		}

		// hang new node from parent or make it the root
		node.parent = parent;

		if (parent == null)
			root = node;

		else if (key.compareTo(parent.GetKey()) < 0)
			parent.left = node;
		
		else 
			parent.right = node;
	}
	
	// print data of all nodes in the subtree passes in the argument
	// printed objects are sorted by their keys
	// private auxilary functions
	void PrintNode(Node node)
	{
		// ignore if node is null
		if (node == null)
			return;
	
		// print left subtree
		PrintNode(node.left);

		// print current node
		System.out.println(node.GetData());

		// print right subtree
		PrintNode(node.right);
	}

	// print all objects in the tree in the order dictated by their keys
	public void Print()
	{
		// print subtree starting at the root
		PrintNode(root);
	}

	// replace subtree rooted at u with subtree rooted at v
	// auxilary private function
	void Transplant(Node u, Node v)
	{
		// check 3 cases
		if (u == root)
		{
			// case 1 - node u is the root
			root = v;
		}

		else if (u == u.parent.left)
		{
			// case 2 - node u is the left child of its parent
			u.parent.left = v;
		}

		else
		{
			// case 3 - node u is the right child of its parent
			u.parent.right = v;
		}
		
		// update upward reference
		if (v != null)
			v.parent = u.parent;
	}

	// remove the given node
	// auxilary private function
	void RemoveNode(Node node)
	{
		// traverse 4 cases
		if (node.left == null)
		{
			// case a - node has no left child
			Transplant(node, node.right);
		}

		else if (node.right == null)
		{
			// case b - node has no right child
			Transplant(node, node.left);
		}

		else
		{
			// get successor
			Node successor = GetMinNode(node.right);

			// check remaining cases
			if (successor == node.right)
			{
				// case c - node's successor is the right child
				Transplant(node, successor);
				successor.left = node.left;
				successor.left.parent = successor;
			}	
			
			else
			{
				// case d - node's successor is not the right child
				Transplant(successor, successor.right);
				Transplant(node, successor);
				successor.left = node.left;
				successor.left.parent = successor;
				
				successor.right = node.right;
				successor.right.parent = successor;	
			}
		}
	}

	public void Remove(Comparable key)
	{
		// find node
		Node node = SearchNode(key);

		// check if present
		if (node == null)
			throw new RuntimeException("Key not found");
		
		// remove it
		RemoveNode(node);
	}

	// find the height from a given node
	// private auxilary function
	int GetNodeHeight(Node node)
	{
		// if the node does not exist, return 0
		// base case
		if (node == null)
			return 0;
		
		// find the height of the right subtree and the left subtree
		int rightHeight = 1 + GetNodeHeight(node.right);
		int leftHeight = 1 + GetNodeHeight(node.left);		
	
		// return whichever height is greater
		if (rightHeight > leftHeight)
			return rightHeight;
		else
			return leftHeight;	
	}

	// find the height of the node associated with the given key
	public int GetHeight(Comparable key)
	{
		// search for the node associated with the given key
		Node node = SearchNode(key);
		
		// if the node does not exist return -1
		if (node == null)
			return -1;

		return GetNodeHeight(node);
	}

	// find the height of the entire tree
	public int GetHeight()
	{
		// if the tree is empty, the height returned is -1
		if (root == null)
			return -1;

		return GetNodeHeight(root);
	}
}
