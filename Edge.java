import java.util.*;

public class Edge implements Comparable{
	public Map<Vertex, Vertex> edgeMap;
	public int cost;
	
	public Edge(Vertex a, Vertex b, int cost){
		edgeMap = new HashMap();
		edgeMap.put(a, b);
		edgeMap.put(b, a);
		
		this.cost = cost; 
	}
	
	public Vertex getNext(Vertex v){
		return edgeMap.get(v);
	}

	@Override
	public int compareTo(Object arg0) {
		return this.cost - ((Edge) arg0).cost; 
	}
	
}
