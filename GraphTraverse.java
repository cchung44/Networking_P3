import java.util.ArrayList;

/**
 * This class simply contains a method to print the edges of an ArrayList<Record> of records
 * 
 * @author mahmoud
 *
 */
public class GraphTraverse {

	/**
	 * This method converts the ArrayList<Record> into an edge list and then prints that edge list.
	 * 
	 * @param recordList	the ArrayList<Record> to convert into an edge list
	 */
	public void printEdges(ArrayList<Record> recordList) {
		EdgeList edgeList = new EdgeList();
		int weight = 0;
		for (int i=1; i<recordList.size(); i++) {
			Record record = recordList.get(i);
			Vertex v1 = record.getVertexAt(record.size() - 2);
			Vertex v2 = record.getLastVertex();
			Edge edge = new Edge(v1, v2);
			weight += edge.getWeight();
			edgeList.addEdge(edge);
		}
		System.out.println(edgeList);
		System.out.println("Total: " + weight);
	}
}
