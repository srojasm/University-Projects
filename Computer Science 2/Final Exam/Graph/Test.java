class Test
{
	public static void main(String args[])
	{
		// instantiate a graph
		Graph graph = new Graph(5);

		// add 5 edges 
		graph.AddEdge(0,1);
		graph.AddEdge(1,3);
		graph.AddEdge(1,4);
		graph.AddEdge(2,1);
		graph.AddEdge(3,2);

		// create lists that represent different paths
		int path1[] = {0,1,3,2,1};
		int path2[] = {0,1,2,3};
		int path3[] = {3,2,1,4};

		// see if a specific path exists and print
		System.out.println("Path: a -> b -> d -> c -> b");
		System.out.println(graph.HasPath(path1) + "\n");

		System.out.println("Path: a -> b -> c -> d");
		System.out.println(graph.HasPath(path2) + "\n");

		System.out.println("Path: d -> c -> b -> e");
		System.out.println(graph.HasPath(path3) + "\n");
	}
}
