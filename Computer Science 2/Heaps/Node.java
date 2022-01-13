class Node implements Comparable
{
	public int frequency;
	public Node left;
	public Node right;
	public int ascii_code;
	public String huffman_code;

	public Node(int ascii_code)
	{
		this.ascii_code = ascii_code;
	}
	
	// inverted comparison to make max heap behave as a min heap
	public int compareTo(Object other)
	{
		Node other_node = (Node) other;
		if (frequency < other_node.frequency)
			return 1;
		else if (frequency > other_node.frequency)
			return -1;
		else
			return 0;
	}

	public void SetHuffmanCode(String huffman_code)
	{
		// save code
		this.huffman_code = huffman_code;

		// set code for left child
		if (left != null)
			left.SetHuffmanCode(huffman_code + "0");

		// set code for right child
		if (right != null)
			right.SetHuffmanCode(huffman_code + "1");
	}
}
