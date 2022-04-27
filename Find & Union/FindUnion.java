// Find and Union DS Implementation

import java.util.Arrays;

public class FindUnion {

    private final int[] parent;
    private final int[] rank;

    public FindUnion(int n) {
        // Initialize each node as a self-loop node
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
        }

        // All The nodes initially have the same rank
        this.rank = new int[n];
        Arrays.fill(this.rank, 1);
    }

    private int find(int n) {
        // find the first parent of the node
        int p = parent[n];
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public boolean union(int n1, int n2) {
        int p1 = find(n1), p2 = find(n2);

        // In The same Set
        // Cycle detected
        if (p1 == p2) return false;

        // Which one has more babies :)
        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}
