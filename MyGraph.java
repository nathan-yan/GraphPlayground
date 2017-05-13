import java.util.*;

public class MyGraph {
	public static void main (String args[]){
		String[] vertexLabels = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
		
		Map<String, Vertex> vertexMap = new HashMap();
		
		for (String s : vertexLabels){
			vertexMap.put(s, new Vertex(s));
		}
		
		// Edge A-C, A-B, A-D
		vertexMap.get("A").putEdge(vertexMap.get("C"), 2);
		vertexMap.get("A").putEdge(vertexMap.get("B"), 1);
		vertexMap.get("A").putEdge(vertexMap.get("D"), 2);
		
		// Edge B-E, B-H
		vertexMap.get("B").putEdge(vertexMap.get("E"), 2);
		vertexMap.get("B").putEdge(vertexMap.get("H"), 10);
		
		// Edge C-D
		vertexMap.get("C").putEdge(vertexMap.get("D"), 1);
		
		// Edge D-F, D-I
		vertexMap.get("D").putEdge(vertexMap.get("F"), 1);
		vertexMap.get("D").putEdge(vertexMap.get("I"), 1);
		
		// Edge E-G, E-F
		vertexMap.get("E").putEdge(vertexMap.get("G"), 5);
		vertexMap.get("E").putEdge(vertexMap.get("F"), 3);
		
		// Edge F-G
		vertexMap.get("F").putEdge(vertexMap.get("G"), 1);
		
		// Edge G-H, G-I
		vertexMap.get("G").putEdge(vertexMap.get("I"), 2);
		vertexMap.get("G").putEdge(vertexMap.get("H"), 2);
		
	}
	
	public static void printShortestPath(Vertex a, Vertex b){
		a.cost = 0;
		
		Vertex current = a;
		
		Set<Vertex> visited = new HashSet<Vertex>();
		Map<Vertex, Vertex> shortestPathBehind = new HashMap<Vertex, Vertex>();
		
		while (!visited.isEmpty()){
			Edge minEdge;
			int minCost = -Integer.MIN_VALUE;
			for (int i = 0; i < current.edges.size(); i++){
				Edge e = current.edges.get(i);
				int costFromVertex = current.cost + e.cost;
							
				if (minCost > costFromVertex){
					minCost = costFromVertex;
					minEdge = e;
				}
				
				/* 
				   *If the cost from everything behind the current node + the 
				   *cost to traverse the connection between current and next is 
				   *less than the current cost of next, update the cost of next,
				   *and update the shortest-path dictionary
				*/
				
				if (costFromVertex < e.edgeMap.get(current).cost){			
					shortestPathBehind.put(e.edgeMap.get(current), current);
				}
			}
			
			visited.add(current);
			
		}
	}	
}











