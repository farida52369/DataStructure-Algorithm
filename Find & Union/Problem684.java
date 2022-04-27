
// USING FIND & UNION DS IN SOME APPLICATIONS

public class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        // Nodes from (1 -> N) inclusive
        FindUnion findUnion = new FindUnion(edges.length + 1);

        int[] res = new int[2];
        for (int[] edge : edges) {
            if (!findUnion.union(edge[0], edge[1])) {
                res[0] = edge[0];
                res[1] = edge[1];
                break;
            }
        }
        return res;
    }
}

// Problem Link: https://leetcode.com/problems/redundant-connection/
// This Solution is 100% faster
