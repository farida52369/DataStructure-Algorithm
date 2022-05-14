
public class Bubble<T extends Comparable<? super T>> implements Sort<T> {

    @Override
    public void sort(T[] arr) {
        for (int i = arr.length; i > 1; i--)
            for (int j = 0; j < i - 1; j++)
                if (arr[j].compareTo(arr[j + 1]) > 0)
                    swap(j, arr);
    }

    private void swap(int index, T[] arr) {
        T temp = arr[index];
        arr[index] = arr[index + 1];
        arr[index + 1] = temp;
    }
}
