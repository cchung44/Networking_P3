/**
 * This class represents an Edge between two adjacent Vertexes and has the weight of the Edge
 * 
 * @author mahmoud
 *
 */
public class Edge {
	private Vertex vertex1, vertex2;
	private int weight;
	
	/**
	 * A constructor that assigns the first and second vertices of the edge and the weight of that edge
	 * 
	 * @param v1	the first vertex of the edge
	 * @param v2	the second vertex of the edge
	 */
	public Edge(Vertex v1, Vertex v2) {
		setVertex1(v1);
		setVertex2(v2);
		weight = (v1.getAdjWeight(v2));
	}

	/**
	 * @return the vertex1
	 */
	public Vertex getVertex1() {
		return vertex1;
	}

	/**
	 * @param vertex1 the vertex1 to set
	 */
	public void setVertex1(Vertex vertex1) {
		this.vertex1 = vertex1;
	}

	/**
	 * @return the vertex2
	 */
	public Vertex getVertex2() {
		return vertex2;
	}

	/**
	 * @param vertex2 the vertex2 to set
	 */
	public void setVertex2(Vertex vertex2) {
		this.vertex2 = vertex2;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * Returns a String representation of the Edge in the format of:
	 * vertex<->vertex	weight
	 * 
	 * @return the String representation of the Edge
	 */
	public String toString() {
		String string = vertex1.getName() + "<->" + vertex2.getName();
		string += " " + weight;
		return string;
	}
}
