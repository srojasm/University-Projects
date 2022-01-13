class Test
{
	public static void main(String args[])
	{
		// have the text passed be the text to be encoded and decoded
		String text = args[0];
	
		// if more than one word is passed, raise an exception
		if (args.length != 1)
			throw new IllegalArgumentException("Only 1 argument accepted otherwise use quotations around phrase");

		// print the input text
		System.out.println("Original text: " +text);

		// create a huffman tree
		Tree tree = new Tree();
		tree.CreateLeafNodes(text);		
		tree.BuildTree();

		// encode the input text and print the encoded text
		String encoded_text = tree.Encode(text);
		System.out.println("Encoded text: " + encoded_text);

		// find the size of the inputed text (the ascii code) and 
		// find the size of the encoded text
		// find the compression ratio and print it
		int input_size = text.length() * 8;
		int huffman_size = encoded_text.length();
		int compression = (huffman_size * 100) / input_size;
		System.out.println("Compression ratio: " + compression + "%");

		// decode the encoded text and print it
		String decoded_text = tree.Decode(encoded_text);
		System.out.println("Decoded text: " + decoded_text);
	}
}
