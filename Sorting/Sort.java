// Selection, Bubble, Insertion, Merge, Quick Sorting Techniques

public class Sort {

    public static void selection(int[] arr) {  // O(N^2)
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min_idx] > arr[j])
                    min_idx = j;
            }
            swap(arr, i, min_idx);
        }
    }

    private static void swap(int[] arr, int idx_1, int idx_2) {
        int temp = arr[idx_1];
        arr[idx_1] = arr[idx_2];
        arr[idx_2] = temp;
    }

    public static void bubble(int[] arr) {  // O(N^2)
        boolean notSwapped;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            notSwapped = true;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    notSwapped = false;
                }
            }
            if (notSwapped) break;
        }
    }

    public static void insertion(int[] arr) {  // O(N^2)
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i], j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void merge(int[] arr) {  // O(Nlog(N))
        merge(arr, 0, arr.length - 1);
    }

    private static void merge(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            merge(arr, left, mid);
            merge(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int len_1 = mid - left + 1, len_2 = right - mid, i;
        int[] arr_1 = new int[len_1], arr_2 = new int[len_2];

        for (i = 0; i < len_1; i++) arr_1[i] = arr[left + i];
        for (i = 0; i < len_2; i++) arr_2[i] = arr[mid + 1 + i];

        i = 0;
        int k = left, j = 0;

        while (i < len_1 && j < len_2) {
            if (arr_1[i] > arr_2[j]) arr[k ++] = arr_2[j ++];
            else arr[k ++] = arr_1[i ++];
        }

        while (i < len_1) {
            arr[k ++] = arr_1[i ++];
        }

        while (j < len_2) {
            arr[k ++] = arr_2[j ++];
        }
    }

    public static void quick(int[] arr) {  // O(Nlog(N))
        quick(arr, 0, arr.length - 1);
    }

    private static void quick(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quick(arr, low, pi - 1);
            quick(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
}
