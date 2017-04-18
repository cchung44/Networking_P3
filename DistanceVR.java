import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Mahmoud on 4/15/2017.
 */
public class DistanceVR {

    /**
     * The method will produce an ArrayList<Record> of results. These are all the valid paths in the
     * graph produced by the algorithm. If the algorithm was running Dijkstra's, for example, it will be
     * all the shortest paths. If it were running BFS, it will be the paths that use the least amount of
     * edges.
     *
     * @param ds	the data structure we will use to maintain records. This
     * parameter is the one that ultimately determines which of the four algorithms you
     * will use.
     * @param graph	the graph we will run on
     * @param startName	This parameter is the name of the start vertex for our traversal.
     * @return	returns the ArrayList<Record> of results
     */
    public ArrayList<Record> traverse(DataStructure<Record> ds, AdjacencyList graph, String startName) {
        ArrayList<Record> recordList = new ArrayList<Record>();
        graph.resetVertices();
        Vertex start = graph.getVertex(startName);
        Record record = new Record(start);
        Record tempRecord;

        ds.add(record);

        while (!ds.isEmpty()) {
            record = ds.remove();
            Vertex v = record.getLastVertex();
            if (!v.isVisited()) {
                recordList.add(record);
                v.setVisited(true);
                for (Vertex vertex : v.getAdjacent()) {
                    if (!vertex.isVisited()) {
                        tempRecord = new  Record(record, vertex);
                        ds.add(tempRecord);
                    }
                }
            }
        }

        return recordList;
    }

    /**
     * The method that will print all the paths in a given ArrayList<Record>
     *
     * @param recordList	the ArrayList<Record> to print the paths of
     */
    public void printPaths(ArrayList<Record> recordList) {
        for (int i=0; i<recordList.size(); i++) {
            System.out.println(recordList.get(i));
        }
    }

    public static void main(String args[]) {
        File graphFile;
        Scanner events;
        boolean printAll = false;
        ArrayList<Integer> eventTimes = new ArrayList<Integer>();
        EdgeList eventEdges = new EdgeList();

        try {
            graphFile = new File(args[0]);
        } catch (Exception e) {
            System.out.println("File not found.");
            return;
        }

        try {
            events = new Scanner(new File(args[1]));
        } catch (Exception e) {
            System.out.println("File not found.");
            return;
        }

        try {
            int arg = Integer.parseInt(args[2]);
            if (arg != 0)
                printAll = true;
            else
                printAll = false;
        } catch (Exception e) {
            System.out.println("3rd Argument is bad");
            return;
        }

        while (events.hasNext()) {
            String[] newLine = events.nextLine().split(" ");
            eventTimes.add(Integer.parseInt(newLine[0]));   //adds the time an event will occur to the list

            int weight = Integer.parseInt(newLine[3]);
            Vertex v1 = new Vertex(newLine[1]);
            Vertex v2 = new Vertex(newLine[2]);
            v1.addAdjVertex(new Vertex(newLine[2]), weight);

            eventEdges.addEdge(new Edge(v1, v2));
        }

        AdjacencyList graph = null;

        try {
            graph = new AdjacencyList(graphFile);
        }
        catch (NullPointerException e) {
            System.out.println("File not there (null)");
        }
        DistanceVR g = new DistanceVR();

        System.out.println("BFS on graph starting at 1:");
        MyQ<Record> queue = new MyQ<Record>();

        ArrayList<Record> recordList = g.traverse(queue, graph, "1");

        g.printPaths(recordList);
        System.out.println();

        GraphTraverse traverse = new GraphTraverse();
        traverse.printEdges(recordList);
        System.out.println();
    }
}