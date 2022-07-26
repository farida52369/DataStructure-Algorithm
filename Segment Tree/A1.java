// https://codeforces.com/edu/course/2/lesson/4/1/practice/contest/273169/problem/A

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int q = Integer.parseInt(tk.nextToken());

        long[] tree = new long[2 * n];
        tk = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            tree[n + i] = Integer.parseInt(tk.nextToken());
        }

        buildSegmentTree(tree, n);

        while ((q--) != 0) {
            tk = new StringTokenizer(input.readLine());
            int type = Integer.parseInt(tk.nextToken());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());

            if (type == 1) { // Set the value
                modify(a, b, n, tree);
            } else {
                long res = query(a, b, tree, n);
                System.out.println(res);
            }
        }
    }

    private static long query(int l, int r, long[] tree, int n) {
        long res = 0;

        for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
            if ((l & 1) != 0) res += tree[l++];
            if ((r & 1) != 0) res += tree[--r];
        }

        return res;
    }

    private static void modify(int i, int val, int n, long[] tree) {
        for (tree[i += n] = val; i > 1; i >>= 1) {
            // i >> 1   -> i / 2
            tree[i >> 1] = tree[i] + tree[i ^ 1];
        }
    }

    private static void buildSegmentTree(long[] tree, int n) {
        for (int i = n - 1; i > 0; i--) {
            // i << 1       -> 2 * i
            // i << 1 | 1   -> 2 * i + 1
            tree[i] = tree[i << 1] + tree[(i << 1) | 1];
        }
    }

}
