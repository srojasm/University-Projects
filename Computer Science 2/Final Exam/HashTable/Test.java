class Test
{
	public static void main(String args[])
	{
		// instantiate a hash table
		HashTable hash_table = new HashTable();
	
		// insert integer keys with null data
		// print the longest chain in the hash table after every insertion
		hash_table.Insert(2,null);
		System.out.println("The longest chain's length: " + hash_table.GetLongestChain());
	
		hash_table.Insert(7,null);	
		System.out.println("The longest chain's length: " + hash_table.GetLongestChain());
		
		hash_table.Insert(5,null);	
		System.out.println("The longest chain's length: " + hash_table.GetLongestChain());
	}
}
