import java.util.*;

public class Graph {
    private int V; // No. of vertices

    // Array of lists -- Represnt Graph
    private List<Integer> adj[];

    @SuppressWarnings("unchecked") // For adj Initialization -:))
    // A warning by which the compiler indicates that it cannot ensure type safety.
    // More info:
    // http://www.angelikalanger.com/GenericsFAQ/FAQSections/TechnicalDetails.html#FAQ001
    Graph(int v) { // Constructor
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // ( v --- w ) in the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    private void DFS(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int n : adj[v]) {
            if (!visited[n])
                DFS(n, visited);
        }
    }

    public void DFS(int v) {
        // false by default in java
        boolean visited[] = new boolean[V];
        DFS(v, visited);
    }

    private boolean search(int v, boolean visited[], int goal) {
        if (v == goal)
            return true;
        visited[v] = true;
        for (int n : adj[v]) {
            if (!visited[n]) {
                boolean is_found = search(n, visited, goal);
                if (is_found)
                    return true;
            }
        }
        return false;
    }

    public boolean search(int v, int goal) {
        // false by default in java
        boolean visited[] = new boolean[V];
        return search(v, visited, goal);
    }

    // Driver Code
    public static void main(String args[]) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(3, 4);

        // Depth - First - Search Traversal
        System.out.println("DFS Starting at vertex(0):");
        g.DFS(0);

        // Search(starting_node, goal): boolean
        if (g.search(2, 4))
            System.out.println("\nWe found the value ..");
        else
            System.out.println("\nWe found No-thing ..");
    }
}
