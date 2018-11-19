import java.util.ArrayList;

public class GraphDemo {

    public static void main(String[] args) {
        GraphAL g = new GraphAL();

        // Empty
        System.out.println("Empty graph: \n" + g);

        // Add
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        System.out.println("Just added 4 vertices\n" + g);
        g.addEdge("A", "E");
        g.addEdge("A", "F");
        g.addEdge("B", "D");
        g.addEdge("D", "A");
        g.addEdge("C", "B");
        g.addEdge("C", "D");
        g.addEdge("F", "D");
        g.addEdge("G", "A");
        g.addEdge("G", "B");
        g.addEdge("G", "C");
        System.out.println("Added the rest using addEdge\n" + g);

        // Traverse
        ArrayList<GraphAL.Vertex> arr = new ArrayList<>();
        arr = g.traverseDFS("A");
        System.out.println("Traversing DFS starting from A " + arr);
        g.resetVisited();
        arr = g.traverseDFS("G");
        System.out.println("Traversing DFS starting from G " + arr);
        g.resetVisited();
        arr = g.traverseBFS("A");
        System.out.println("Traversing BFS starting from A " + arr);
        g.resetVisited();
        arr = g.traverseBFS("G");
        System.out.println("Traversing BFS starting from G " + arr);
        g.resetVisited();

        // Delete
        g.deleteVertex("D");
        System.out.println("Deleted vertex D\n" + g);
        g.deleteEdge("G", "B");
        System.out.println("Deleted edge G-->B\n" + g);
        String graphLastState = g.toString();
        g.deleteVertex("H");
        System.out.println("Deleted a non-existent vertex H. Has graph changed?\t" + !graphLastState.equals(g.toString()));
        g.deleteEdge("C", "A");
        System.out.println("Deleted a non-existent edge C-->A. Has graph changed?\t" + !graphLastState.equals(g.toString()));

    }
}
