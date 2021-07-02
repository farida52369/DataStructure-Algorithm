/************** BEST TYPE OF SORTING *************
DIVIDE AND CONQUER TECNIQUE .. IT'S A WAY OF THINKING MORE THAN AN ALGORITHM
BEST AND AVERAGE TIME IMPLEMENTATION: O(NlogN)
WORST TIME: O(N)

COMPARING BETWEEN MERGE AND QUICK SORT
QUICK SORT IS BETTER ALTHOUGH BEST AVERAGE WORST TIME IN MERGE O(NlogN)
BUT THE CONSTANT WITH MERGE IS MUCH BIGGER AND QUICK SORT HIT THE WORST CASE RARELY

*/

import java.util.Scanner;

public class QuickSort {

    public void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Choosing a PIVOT 
    // and make its left lower than the pivot and its right higher than the pivot ..
    public int partitioning(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int index = (low - 1);
        for (int i = low; i <= high; i++)
        {
            if (pivot > arr[i])
            {
                index ++;
                swap(arr, i, index);
            }
        }
        swap(arr, ++index, high);
        return index;
    }

    // Choosing a PIVOT 
    // and make its left higher than the pivot and its right lower than the pivot ..
    public int partitioningReverse(int[] arr, int low, int high)
    {
        int pivot = arr[low];
        int index = (high + 1);

        for (int i = low; i <= high; i++)
        {
            if (pivot > arr[i])
            {
                index --;
                swap(arr, index, i);
            }
        }
        swap(arr, --index, low);
        return index;
    }

    // Shifting makes it difficult -- and time waste
    public int partitioningInOrder(int[] arr, int low, int high)
    {
        int pivot = arr[low];
        int index = (low - 1);

        for (int i = low; i <= high; i++)
        {
            if (pivot > arr[i])
            {
                index ++;
                int temp = arr[i];
                for (int j = i - 1; j >= low; j--)
                {
                    arr[j + 1] = arr[j];
                }
                arr[low] = temp;

            }
        }
        return ++index;
    }

    public void quickSort(int[] arr, int low, int high)
    {
        // High should be strictly higher than low
        if (high > low)
        {
            // Indexing of the pivot ..
            // And making partition in the array
            int pivot = partitioning(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);

        }
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = input.nextInt();

        QuickSort obj = new QuickSort();
        obj.quickSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}

// The END :"))))
