import java.util.*;

public class Vertex{
	public String label;
	public List<Edge> edges;
	
	public int cost;
	
	public Vertex(String label){
		edges = new ArrayList();
		this.label = label;
		this.cost = Integer.MAX_VALUE;
	}
	
	public void putEdge(Vertex other, int cost){
		edges.add(new Edge(this, other, cost));
		other.edges.add(new Edge(this, other, cost));
		
	}
	
	@Override
	public int hashCode(){
		return label.hashCode();
	}
}
