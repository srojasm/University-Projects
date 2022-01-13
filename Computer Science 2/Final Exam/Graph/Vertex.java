class Vertex
{
	public Edge edge;
		
	// colors
	public static final int WHITE = 0;
	public static final int GRAY = 1;
	public static final int BLACK = 2;

	// fields for BFS
	public int color;
	public int distance;
	public int parent;

}
