class Tree
{
	Node root;
	Node leaf_nodes[];
	
	public void CreateLeafNodes(String ascii_text)
	{
		// array of leaf nodes indexed by ASCII code
		leaf_nodes = new Node[256];

		// parse text
		for (int i = 0; i < ascii_text.length(); i++)
		{
			// get ASCII code for current character
			int ascii_code = ascii_text.charAt(i);

			// create node if it does not exist
			if (leaf_nodes[ascii_code] == null)
				leaf_nodes[ascii_code] = new Node(ascii_code);

			// increment frequency
			leaf_nodes[ascii_code].frequency++;
		}
	}

	public void BuildTree()
	{
		// create heap
		Heap heap = new Heap();

		// insert all leaf nodes
		for (int i = 0; i < 256; i++)
			if (leaf_nodes[i] != null)
				heap.Insert(leaf_nodes[i]);
		
		// build tree
		while (heap.GetLength() > 1)
		{
			// extract 2 nodes with minimum frequency
			Node left = (Node) heap.ExtractMax();
			Node right = (Node) heap.ExtractMax();
			
			// Create new node and make it the root for now
			root = new Node(0);
			root.left = left;
			root.right = right;
			root.frequency = left.frequency + right.frequency;

			// insert new node i heap
			heap.Insert(root);	
		}	

		// set huffman codes
		root.SetHuffmanCode("");
	}

	public String Encode(String ascii_text)
	{
		// initialize result
		String huffman_text = "";

		// traverse ASCII text
		for (int i = 0; i < ascii_text.length(); i++)
		{
			// Get ASCII code
			int ascii_code = ascii_text.charAt(i);

			// check if character is supported
			if (leaf_nodes[ascii_code] == null)
				throw new RuntimeException("Character not supported: " +
					ascii_text.charAt(i));
	
			// get huffman code
			String huffman_code = leaf_nodes[ascii_code].huffman_code;

			// add it
			huffman_text += huffman_code;

			// message
			// System.out.println(ascii_text.charAt(i) + " -> " + huffman_code);
		}

		// result
		return huffman_text;
	}

	public String Decode(String huffman_text)
	{
		// initialize the ascii text string
		String ascii_text = "";

		// set the current node to the root
		Node current = root;

		// traverse huffman text
		for (int i = 0; i < huffman_text.length(); i++)
		{

			// if the current character is 0, make the 
			// current node one to the left
			if (huffman_text.charAt(i) == '0')
				current = current.left;				

			// if the current character is 1, 
			// make the current node one to right
			else if (huffman_text.charAt(i) == '1')
				current = current.right;	

			// if the character is neither 1 or 0, throw an exception
			else
				throw new RuntimeException("Huffman Tree contains"
					+ " an unsupported character " + 
					huffman_text.charAt(i));

			// if you've reached a leaf node 
			if (current.right == null && current.left == null)
			{
				// find the ascii code of the leaf node
				int ascii_code = current.ascii_code;

				// get the letter associated with the ascii code
				String ascii_character = Character.toString((char)ascii_code);

				// add the character to the ascii string
				ascii_text += ascii_character;
				current = root;
			}
		}
		
		// return the ascii text
		return ascii_text; 
	}
}
