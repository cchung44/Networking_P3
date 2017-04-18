import java.util.ArrayList;

/**
 * A list of edges
 * 
 * @author mahmoud
 *
 */
public class EdgeList {
	ArrayList<Edge> edgeList;
	
	/**
	 * A constructor that just instantiates the edgeList
	 */
	public EdgeList() {
		edgeList = new ArrayList<Edge>();
	}
	
	/**
	 * Adds an edge to the EdgeList
	 * 
	 * @param edge	the edge to add to the EdgeList
	 */
	public void addEdge(Edge edge) {
		edgeList.add(edge);
	}
	
	/**
	 * Returns a String representation of the EdgeList
	 * 
	 * @return the String representation of the EdgeList
	 */
	public String toString() {
		String string = "";
		for (int i=0; i<edgeList.size(); i++) {
			string += edgeList.get(i);
			if (i != edgeList.size()-1)
				string += "\n";		// add a new line after all but the last edge
		}
		return string;
	}
}
