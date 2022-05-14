
import java.util.ArrayList;
import java.util.List;

public class Merge<T extends Comparable<? super T>> implements Sort<T> {

    @Override
    public void sort(T[] arr) {
        //
        merge(arr, 0, arr.length - 1);
    }

    private void merge(T[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            merge(arr, left, mid);
            merge(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(T[] arr, int left, int mid, int right) {
        int len_1 = mid - left + 1, len_2 = right - mid, i;

        // as arrays can't be initialized in generic type __ Java care :)
        // using ArrayList as they are the same as Arrays but in the shape of List
        List<T> arr_1 = new ArrayList<>(len_1), arr_2 = new ArrayList<>(len_2);

        for (i = 0; i < len_1; i++) arr_1.add(arr[left + i]);
        for (i = 0; i < len_2; i++) arr_2.add(arr[mid + 1 + i]);

        i = 0;
        int k = left, j = 0;

        while (i < len_1 && j < len_2) {
            if (arr_1.get(i).compareTo(arr_2.get(j)) > 0)
                arr[k++] = arr_2.get(j++);
            else arr[k++] = arr_1.get(i++);
        }

        while (i < len_1) {
            arr[k++] = arr_1.get(i++);
        }

        while (j < len_2) {
            arr[k++] = arr_2.get(j++);
        }
    }
}
