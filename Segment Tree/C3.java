// https://codeforces.com/edu/course/2/lesson/4/1/practice/contest/273169/problem/C

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C3 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int q = Integer.parseInt(tk.nextToken());

        long[][] treeM = new long[2 * n][2];
        tk = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            treeM[n + i][0] = Integer.parseInt(tk.nextToken());
            treeM[n + i][1] = 1;
        }

        buildSegmentTree(treeM, n);
        // printTree(treeM);

        while ((q--) != 0) {
            tk = new StringTokenizer(input.readLine());
            int type = Integer.parseInt(tk.nextToken());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());

            if (type == 1) { // Set the value
                modify(a, b, n, treeM);
                // printTree(treeM);
            } else {
                long[] res = query(a, b, treeM, n);
                System.out.println(res[0] + " " + res[1]);
            }
        }
    }

    private static void printTree(long[][] tree) {
        for (long[] t : tree) {
            for (long j : t) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static long[] query(int l, int r, long[][] tree, int n) { // O(2logN)

        long res = Long.MAX_VALUE;
        long freq = 0;

        // Get the minimum
        for (int l_ = l + n, r_ = r + n; l_ < r_; l_ >>= 1, r_ >>= 1) {
            if ((l_ & 1) != 0) res = Math.min(res, tree[l_++][0]);
            if ((r_ & 1) != 0) res = Math.min(res, tree[--r_][0]);
        }

        // Get the freq of the minimum
        for (int l_ = l + n, r_ = r + n; l_ < r_; l_ >>= 1, r_ >>= 1) {
            if ((l_ & 1) != 0) {
                if (tree[l_][0] == res) {
                    freq += tree[l_][1];
                }
                l_++;
            }
            if ((r_ & 1) != 0) {
                --r_;
                if (tree[r_][0] == res) {
                    freq += tree[r_][1];
                }
            }
        }

        return new long[]{res, freq};
    }

    private static void modify(int i, int val, int n, long[][] tree) {

        for (tree[i += n][0] = val; i > 1; i >>= 1) {
            // i >> 1   -> i / 2
            tree[i >> 1] = comp(tree[i], tree[i ^ 1]);
        }
    }

    private static void buildSegmentTree(long[][] tree, int n) {
        for (int i = n - 1; i > 0; i--) {
            // i << 1       -> 2 * i
            // i << 1 | 1   -> 2 * i + 1
            tree[i] = comp(tree[i << 1], tree[(i << 1) | 1]);
        }
    }

    private static long[] comp(long[] a, long[] b) {
        if (a[0] < b[0]) return a;
        if (a[0] > b[0]) return b;
        return new long[] {a[0], a[1] + b[1]};
    }
}
