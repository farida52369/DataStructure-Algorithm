
import java.util.Arrays;

public class MaxHeap implements IMaxHeap {

    private int[] heap;
    private int size;
    private int maxSize;
    private static final int MAX_SIZE = 10;

    public MaxHeap() {
        this.maxSize = MAX_SIZE;
        this.size = 0;
        this.heap = new int[this.maxSize];
    }

    // Getting Parent _ Left Child _ Right Child
    private int parent(int i) {
        return ((i - 1) / 2);
    }

    private static int leftChild(int i) {
        return (2 * i) + 1;
    }

    // SWAPPING
    private static void swap(int[] heap, int index_1, int index_2) {
        int temp = heap[index_1];
        heap[index_1] = heap[index_2];
        heap[index_2] = temp;
    }

    @Override // INSERTION __
    public void insert(int data) {
        if (size >= maxSize) {
            heap = Arrays.copyOf(heap, size + maxSize);
            maxSize = (size + maxSize);
        }

        heap[size] = data;
        int i = size;
        while (i > 0 && heap[i] > heap[parent(i)]) {
            swap(heap, i, parent(i));
            i = parent(i);
        }
        size += 1;
    }

    @Override // REMOVE MAX VALUE __
    public Integer extractMax() {
        if (size > 0) {
            int returnedVal = heap[0];

            swap(heap, 0, size - 1);
            size -= 1;
            maxHeapify(heap, size, 0);
            return returnedVal;
        }
        return null;
    }


    public static void sort(int[] arr) {
        int size = arr.length;

        buildMaxHeap(arr, size); // Takes O(N)
        removeMaxHeap(arr, size); // Takes O(Nlog(N))
        // OverAll Time Complexity: O(Nlog(N))
    }

    // WOW! __ MAX HEAPIFY
    private static void maxHeapify(int[] heap, int size, int i) {
        int left = leftChild(i), right = left + 1, largest;

        if (left < size && heap[left] > heap[i]) largest = left;
        else largest = i;

        if (right < size && heap[right] > heap[largest])
            largest = right;

        if (largest != i) {
            swap(heap, i, largest);
            maxHeapify(heap, size, largest);
        }
    }

    private static void buildMaxHeap(int[] heap, int size) {
        int len = (size / 2) - 1;
        // from O(NlogN) to O(N)
        for (int i = len; i >= 0; i--) {
            maxHeapify(heap, size, i);

        }
    }

    private static void removeMaxHeap(int[] heap, int size) {
        while (size > 0) {
            swap(heap, 0, size - 1);
            size -= 1;
            maxHeapify(heap, size, 0);
        }
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
