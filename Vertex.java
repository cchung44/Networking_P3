import java.util.HashMap;
import java.util.Set;

/**
 * This is a Vertex class that represents a Vertex in a graph and has a boolean to mark whether it's been visited
 * as well as a HashMap of the vertices adjacent to this Vertex.
 * 
 * @author mahmoud
 *
 */
public class Vertex {
	private String name;
	private boolean visited;
	private HashMap<Vertex, Integer> adjMap;
	
	/**
	 * A constructor that sets the name of this vertex to name and sets the "visited" boolean to false
	 * 
	 * @param name	the name of the Vertex
	 */
	public Vertex(String name) {
		this.setName(name);
		setVisited(false);
		adjMap = new HashMap<Vertex, Integer>();
	}
	
	/**
	 * Adds an adjacent Vertex to this Vertex's adjacency structure and the weight of the edge between the two vertices
	 * 
	 * @param v			the adjacent Vertex to add
	 * @param weight	the weight of the edge between this Vertex and the Vertex v
	 */
	public void addAdjVertex(Vertex v, int weight) {
		if (adjMap.containsKey(v)) 
			return;
		adjMap.put(v, weight);
	}
	
	/**
	 * Gets the weight of the edge between this Vertex and an adjacent Vertex
	 * 
	 * @param v	the adjacent Vertex
	 * @return	the weight of the edge between this Vertex and the Vertex v as an Integer object. 
	 * Returns null if v is not in this Vertex's adjacency structure
	 */
	public Integer getAdjWeight(Vertex v) {
		if (adjMap.containsKey(v)) {
			return (Integer) (adjMap.get(v));
		}
		return null;
	}

	/**
	 * Returns a set of the vertices adjacent to this Vertex
	 * 
	 * @return a set of the vertices adjacent to this Vertex
	 */
	public Set<Vertex> getAdjacent() {
		return adjMap.keySet();
	}
	
	/**
	 * Returns a string representation of this Vertex and all its adjacent vertices in the format of:
	 * Name : <adjacent Vertex, weight> <adjacent Vertex, weight> <adjacent Vertex, weight>
	 * 
	 * @return a string representation of this Vertex and all its adjacent vertices
	 */
	public String toString() {
		String s = this.name + ": ";
		StringBuilder string = new StringBuilder(s);
		for (Vertex vertex : adjMap.keySet()) {
			string.append("<");
			string.append(vertex.getName());
			string.append(", ");
			string.append(adjMap.get(vertex));
			string.append("> ");
		}
		return string.toString();
	}
	
	/**
	 * Returns the name of this Vertex
	 * 
	 * @return a String representing the name of this Vertex
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of this Vertex to the name passed in
	 * 
	 * @param name the name to set the Vertex's name to
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns a boolean representing whether or not this Vertex has been visited
	 * 
	 * @return true if the Vertex has been visited, false if it hasn't
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * Sets the "visited" boolean to the boolean passed in
	 * 
	 * @param visited the boolean to set "visited" to
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
