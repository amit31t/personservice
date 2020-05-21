package com.trip.dsa.graph;

public class MainGraph {

	public static void main(String[] args) 
	{
		int vertices =5;
		//adjacencyMatrixGraphRepresentation(vertices);
		
		adjacencyListGraphRepresentation(vertices);
	}

	private static void adjacencyListGraphRepresentation(int vertices) 
	{
		AdjacencyListGraph graph = new AdjacencyListGraph(vertices);
		Vertix1 v1 = graph.addVertix("A"); 
		Vertix1 v2 = graph.addVertix("B"); Vertix1 v3 = graph.addVertix("C"); Vertix1 v4 =graph.addVertix("D"); Vertix1 v5 = graph.addVertix("E");
		graph.addEdge(v1, v2);
		graph.addEdge(v1, v3);
		graph.addEdge(v1, v5);
		graph.addEdge(v2, v4);
		graph.addEdge(v2, v1);
		graph.addEdge(v3, v5);
		graph.addEdge(v4, v2);
		graph.addEdge(v5, v3);
		
		graph.printAdjacencyListGraph();
}
	private static void adjacencyMatrixGraphRepresentation(int vertices)
	{
		AdjacencyMatrixGraphR graph = new AdjacencyMatrixGraphR(vertices);
		graph.addVertices("A", "B", "C", "D", "E");
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("A", "E");
		graph.addEdge("B", "C");
		graph.addEdge("B", "E");
		graph.addEdge("E", "D");
		graph.addEdge("C", "D");
		
		graph.printAdjacencyMatrixGraph();
	}

}
