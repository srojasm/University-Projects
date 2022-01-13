class Person
{
	String name;
	int age;
	
	public Person(String name, int age)
	{
		// Constructor
		// assigns the age and name to the private properties
		this.name = name;
		this.age = age;
	}
	
	public void Print()
	{
		// prints persons name and age in specific format
		System.out.print("Name: " + name);
		System.out.print("\nAge: " + age);	
	}
	
	public boolean IsUnderage()
	{
		// returns a boolean value 
		// for whether or not the person is under 18 years old
		boolean b;
		b = age < 18;
		return b;
	}
}
