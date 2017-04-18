import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This is a class that maintains a master list of all vertexes in the graph
 * 
 * @author mahmoud
 *
 */
public class AdjacencyList {
	private Scanner scanner;
	private HashMap<String, Vertex> adjacencyList;
	
	/**
	 * A constructor that reads in a file in edge list format and creates an AdjacencyList out of it
	 * 
	 * @param fileToRead the file in edge list format
	 */
	public AdjacencyList(File fileToRead) {
		try {
			scanner = new Scanner(fileToRead);
		}
		catch (FileNotFoundException e){
			System.out.println("Unable to find file " + fileToRead + ": " + e.getMessage());
		}
		
		adjacencyList = new HashMap<String, Vertex>();
		
		while (scanner.hasNext()) {
			String[] newLine = scanner.nextLine().split(" ");
			Vertex adjVertex;
			Vertex vertex;
			
			if (adjacencyList.containsKey(newLine[1]))	// check if the neighboring vertex is already in the adjList
				adjVertex = adjacencyList.get(newLine[1]);
			else {		// if not, create the vertex and add it to the list
				adjVertex = new Vertex(newLine[1]);
				adjacencyList.put(newLine[1], adjVertex);
			}
			
			if (adjacencyList.containsKey(newLine[0]))
				vertex = adjacencyList.get(newLine[0]);
			else {		// if the vertex is not already in the adjList, create it and add it to the list
				vertex = new Vertex(newLine[0]);
				adjacencyList.put(newLine[0], vertex);
			}
			
			Integer weight =  	Integer.parseInt(newLine[2]);	// the weight of the edge between the 2 vertices
			vertex.addAdjVertex(adjVertex, weight);
			adjVertex.addAdjVertex(vertex, weight);
		}
	}
	
	/**
	 * Returns a Vertex object with the same name as the name passed in
	 * 
	 * @param name the name of the Vertex to retrieve
	 * @return the Vertex object with that name
	 */
	public Vertex getVertex(String name) {
		return adjacencyList.get(name);
	}
	
	/**
	 * Resets the boolean flag "visited" of all the vertices in the Adjacency List to false;
	 */
	public void resetVertices() {
		for (String vertexName : adjacencyList.keySet())
			adjacencyList.get(vertexName).setVisited(false);
	}
	
	/**
	 * Returns a String of each Vertex's toString in separate lines
	 * 
	 * @return the String representation of the AdjacencyList
	 */
	public String toString() {
		StringBuilder string = new StringBuilder("");
		for (String s : adjacencyList.keySet()) {
			Vertex v = adjacencyList.get(s);
			string.append(v.toString());
			string.append("\n");
		}
		
		return string.toString();
	}
	
	public static void main(String[] args) {
		File book = new File("/home/mahmoud/Desktop/book1.txt");
		
		try {
			AdjacencyList adjList = new AdjacencyList(book);
			System.out.println(adjList);
		}
		catch (NullPointerException e) {
			System.out.println("File not there (null)");
		}
	}
}
