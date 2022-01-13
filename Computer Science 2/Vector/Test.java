class Test
{
	public static void main(String args[])
	{
		// instantiate a vector
		Vector vector = new Vector();
	
		// add items
		vector.Add(Integer.valueOf(0));
		vector.Add(Integer.valueOf(1));
		vector.Add(Integer.valueOf(2));
		vector.Add(Integer.valueOf(3));
		vector.Add(Integer.valueOf(4));
		
		vector.Print();
	
		// remove item
		vector.Remove(1);
		vector.Print();

		vector.Remove(1);
		vector.Print();
	
		vector.Remove(1);		
		vector.Print();

		vector.Remove(1);		
		vector.Print();
	}
}
