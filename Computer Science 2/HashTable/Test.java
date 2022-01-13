class Test
{
	public static void main(String args[])
	{
		// instantiate a hash table
		HashTable hashtable = new HashTable();
		
		// create four persons
		Person person_a = new Person("John", 27);
		Person person_b = new Person("Adam", 25);
		Person person_c = new Person("Zack", 27);
		Person person_d = new Person("Mary", 29);

		// insert four persons where their names are the key
		hashtable.Insert(person_a.GetName(),person_a);
		hashtable.Insert(person_b.GetName(),person_b);
		hashtable.Insert(person_c.GetName(),person_c);
		hashtable.Insert(person_d.GetName(),person_d);

		// find the successor for one of the people and print
		Object Mary_Successor = hashtable.GetSuccessor("Mary");
		System.out.println("Successor of Mary: " + Mary_Successor);

		// find the successor for another one of the people and print
		Object Zack_Successor = hashtable.GetSuccessor("Zack");
		System.out.println("Successor of Zack: " + Zack_Successor);
	}
}
