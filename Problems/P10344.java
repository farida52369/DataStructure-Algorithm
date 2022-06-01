// P10344 - 23 out of 5 __ Online Judge
// BackTracking __ next_permutation In java :)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10344 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer tk = new StringTokenizer(input.readLine());
            // constructing the array input
            int sum = 0;
            int[] arr = new int[5];
            for (int i = 0; i < 5; i++) {
                arr[i] = Integer.parseInt(tk.nextToken());
                sum += arr[i];
            }
            if (sum == 0)
                break;

            // sort the array __ help to get the next permutation
            Arrays.sort(arr);
            boolean possible = false;
            do {
                if (backTracking(1, arr[0], arr)) {
                    possible = true;
                    System.out.println("Possible");
                    break;
                }

            } while (next_permutation(arr));

            if (!possible)
                System.out.println("Impossible");

        }
    }

    private static boolean next_permutation(int[] arr) {
        if (arr.length <= 1) return false;

        int last = arr.length - 2;
        while (last >= 0 && arr[last] >= arr[last + 1]) last--;

        // possibilities exhausted
        if (last < 0) return false;

        int next_greater = arr.length - 1;
        while (arr[next_greater] <= arr[last]) next_greater -= 1;
        swap(arr, last, next_greater);

        reverse(arr, last + 1, arr.length - 1);
        return true;
    }

    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    private static boolean backTracking(int i, int val, int[] arr) {
        if (i == 5) {
            return val == 23;
        }

        return backTracking(i + 1, val + arr[i], arr) ||
                backTracking(i + 1, val - arr[i], arr) ||
                backTracking(i + 1, val * arr[i], arr);
    }
}
