// SOLVING MINIMUM SPANNING TREE KRUSKAL'S ALGORITHM USING FIND & UNION DS
// TIME COMPLEXITY: O(ElogE + ElogV)

import java.util.Arrays;
import java.util.Comparator;

public class MST {

    private final int[][] edges;
    private final int N;
    private final int[][] result;
    private final FindUnion detectCycles;

    // Each Edge is represented by
    // 1) source Node  __  edges[0]
    // 2) destination Node  __  edges[1]
    // 3) weight  __  edges[2]
    // Nodes represented from [0 -> N)
    public MST(int[][] edges, int N) {
        this.edges = edges;
        this.N = N;

        // Minimum Spanning Tree Edges
        // Spanning Tree Edges must be (N - 1)
        // Otherwise there must be a cycle
        // It's a graph Not Tree then.
        this.result = new int[N - 1][3];

        //  To detect Cycles
        this.detectCycles = new FindUnion(N);
    }

    private void solveMST() {
        // Sort The edges according To their weight
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));

        int numOfEdges = 0, i = 0;
        while (N -1 > numOfEdges) { // MST condition
            if (detectCycles.union(edges[i][0], edges[i][1])) {
                result[numOfEdges][0] = edges[i][0];
                result[numOfEdges][1] = edges[i][1];
                result[numOfEdges][2] = edges[i][2];
                numOfEdges += 1;
            }
            i++;
        }
    }

    public int[][] getMSTEdges() {
        solveMST();
        return result;
    }
}
