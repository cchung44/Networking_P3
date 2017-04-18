import java.util.ArrayList;

/**
 * A Record keeps track of a path of vertices in some list, the total length of the edge weights in
 * the path,  and the weight of the last edge in the path
 * 
 * @author mahmoud
 *
 */
public class Record {
	private Vertex lastVertex;
	private int pathDistance, lastWeight, size;
	private ArrayList<Vertex> path;
	
	/**
	 * A constructor that takes in one Vertex and makes a default path out of this vertex
	 * 
	 * @param v the Vertex to be used to create the path with
	 */
	public Record(Vertex v) {
		path = new ArrayList<Vertex>();
		path.add(v);
		size = 1;
		lastVertex = v;
		pathDistance = 0;
	}
	
	/**
	 * A constructor that takes in an existing Record and copies the data over (path list is deep copied)
	 * 
	 * @param r the Record whose data will be copied over
	 */
	public Record(Record r) {
		path = new ArrayList<Vertex>();
		for (int i=0; i < r.size(); i++) 
			path.add(r.getVertexAt(i));
		size = r.size();
		lastVertex = r.getLastVertex();
		pathDistance = r.getPathDistance();
		lastWeight = r.getLastWeight();
	}
	
	/**
	 * A constructor that takes in a Record and a Vertex, copies the existing Record over (deep copy)
	 * and adds the Vertex to its path
	 * 
	 * @param r the Record whose data will be copied over
	 * @param v	the Vertex to be added to the path
	 */
	public Record(Record r, Vertex v) {
		path = new ArrayList<Vertex>();
		for (int i=0; i< r.size; i++)
			path.add(r.getVertexAt(i));
		size = r.size();
		pathDistance = r.getPathDistance();
		lastVertex = r.getLastVertex();
		addVertex(v);
	}
	
	/**
	 * Adds a Vertex to the existing path
	 * 
	 * @param v the Vertex to be added to the path
	 */
	public void addVertex(Vertex v) {
		path.add(v);
		size++;
		lastWeight = lastVertex.getAdjWeight(v);
		lastVertex = v;
		pathDistance += lastWeight;
	}
	
	/**
	 * Returns a string representation of the Record in the following format:
	 * Path: vertex->vertex->vertex->vertex-> Distance: path distance
	 * 
	 * @return the string representation of the Record
	 */
	public String toString() {
		StringBuilder string = new StringBuilder("Path: ");
		for (Vertex v : path) {
			string.append(v.getName());
			string.append(" -> ");
		}
		string.append("   Distance: " + pathDistance);
		return string.toString();
	}
	
	/**
	 * Gets the path list (which is an ArrayList)
	 * 
	 * @return the path
	 */
	public ArrayList<Vertex> getPath() {
		return path;
	}
	
	/**
	 * Gets the weight of the last edge added to the path
	 * 
	 * @return weight of the last edge added to the path
	 */
	public int getLastWeight() {
		return lastWeight;
	}
	
	/**
	 * Gets the total distance (sum of weights) of the path
	 * 
	 * @return the total distance of the path
	 */
	public int getPathDistance() {
		return pathDistance;
	}
	
	/**
	 * Gets the size of the path
	 * 
	 * @return the number of vertices in the path
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Gets a Vertex in the path by its index
	 * 
	 * @param i	the index of the Vertex
	 * @return	the Vertex in the path at that index
	 */
	public Vertex getVertexAt(int i) {
		return path.get(i);
	}
	
	/**
	 * Gets the last Vertex added to the path
	 * 
	 * @return the last Vertex in the path
	 */
	public Vertex getLastVertex() {
		return lastVertex;
	}

	
	public static void main(String[] args) {
		Vertex A = new Vertex("A");
		Record r = new Record(A);
		System.out.println(r);
		String[] vertices = {"B", "C", "D", "E"};
		for (int i=0; i<(vertices.length); i++) {
			Vertex newVertex = new Vertex(vertices[i]);
			r.getLastVertex().addAdjVertex(newVertex, i+1);
			r.addVertex(newVertex);
		}
		System.out.println(r);
		
		Vertex F = new Vertex("F");
		r.getLastVertex().addAdjVertex(F, 1);
		Record rThirdConst = new Record(r, F);
		System.out.println(rThirdConst);
		
		Record rSecondConst = new Record(r);
		System.out.println(rSecondConst);
		
		Record rSecondConst2 = new Record(rThirdConst);
		System.out.println(rSecondConst2);
		
		//r.addVertex(F);
		//System.out.println(r);
	}
}
