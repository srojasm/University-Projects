import java.util.ArrayDeque;
import java.util.Queue;

class Graph
{
	int size;
	Vertex vertices[];
	
	public Graph(int size)
	{
		// save size
		this.size = size;

		// allocate array of vertices
		vertices = new Vertex[size];
	
		// create vertices
		for (int i = 0; i< size; i++)
			vertices[i] = new Vertex();
	}

	public void AddEdge(int source, int target)
	{
		// create new edge
		Edge edge = new Edge(target);

		// add it to adjacency list
		edge.next = vertices[source].edge;
		vertices[source].edge = edge;
	}

	public void AddUndirectedEdge(int source, int target)
	{
		AddEdge(source, target);
		AddEdge(target, source);
	}

	public int GetSize()
	{
		return size;
	}

	public void Print()
	{
		System.out.println("** Graph **");
		
		// traverse vertices
		for (int i = 0; i < size; i++)
		{
			// title
			System.out.println("Vertex " + i + ":");
	
			// print edges
			System.out.println("  Edges:");
			for (Edge edge = vertices[i].edge; edge != null; edge = edge.next)
				System.out.println("   " + i + " -> " + edge.target);
		}
	}

	public void BFS(int start)
	{
		// initialize
		for (int i = 0; i < size; i++)
		{
			vertices[i].color = Vertex.WHITE;
			vertices[i].distance = Integer.MAX_VALUE;
			vertices[i].parent = -1;
		}

		// initialize start vertex
		vertices[start].color = Vertex.GRAY;
		vertices[start].distance = 0;

		// insert start vertex in queue
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(start);
	
		// process queue
		while (queue.peek() != null)
		{
			// extract vertex from queue
			int source = queue.remove();

			// traverse adjacency list
			for (Edge edge = vertices[source].edge; edge != null; edge = edge.next)
			{
				int target = edge.target;
				if (vertices[target].color == Vertex.WHITE)
				{
					// update target vertex
					vertices[target].color = Vertex.GRAY;
					vertices[target].parent = source;
					vertices[target].distance = vertices[source].distance + 1;
					// enqueue target vertex
					queue.add(target);
				}
			}

			// finish processing vertex
			vertices[source].color = Vertex.BLACK;
		}
	}	
	
	void PrintShortestPath(int source, int target)
	{
		if (source == target)
		{
			System.out.print(source);
		}

		else if (vertices[target].parent == -1)
		{
			System.out.print("unreachable");
		}
	
		else
		{
			PrintShortestPath(source, vertices[target].parent);
			System.out.print(" -> " + target);
		}
	}

	// check if an edge that connects a source vertex witha target vertex exists
	boolean HasEdge(int source, int target)
	{
		// traverse all the edges at the source vertex
		for (Edge edge = vertices[source].edge; edge != null; edge = edge.next)
			// if the target of any of the edges is equal to the
			// target passed as an argument, then return true
			if(edge.target == target)
				return true;
		
		// return false if none of the edges's target is the target passed
		return false;
	}

	// check if a specific path exists within a graph
	public boolean HasPath(int v[])
	{
		// traverse the list that represents the path 
		for (int i = 0; i < v.length - 1; i++)
		{
			// if there is not an edge that connects the current vertex (i)
			// to the next vertex (i+1), return false
			if(HasEdge(v[i],v[i+1]) == false)
				return false;
		}

		// if there is an edge to connect every vertex to the next vertex,
		// return true
		return true;	
	}
}
