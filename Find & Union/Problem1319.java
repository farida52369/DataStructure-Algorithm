// Problem Link: https://leetcode.com/problems/number-of-operations-to-make-network-connected/
// Implemented using Find & Union DS

public class Solution {

    public int makeConnected(int n, int[][] connections) {

        // graph of N nodes we need (N - 1) edges to be connected
        if (n - 1 > connections.length) return -1;

        // Using find & union DS
        // each Node in parent array is self-loop
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int validE = 0;
        for (int[] connection : connections) {
            validE += union(connection[0], connection[1], parent);
        }

        return n - 1 - validE;
    }

    private int find(int n, int[] parent) {
        int p = parent[n];
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private int union(int n1, int n2, int[] parent) {
        int p1 = find(n1, parent), p2 = find(n2, parent);
        parent[p1] = p2;

        // generate a cycle ? 0 : 1 (1 -> normal edge)
        return p1 == p2 ? 0 : 1;
    }
}
