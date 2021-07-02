/***************** SELECTION SORT ****************

ABOUT COMPARING EACH ELEMENT WITH THE WHOLE ARRAY TO FINALLY SWAP THE MIN NUM WITH THE CURRENT ONE ..
**************************************************/

import java.util.Scanner;

public class SelectionSort {

    public void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Take each element and compare it with the rest of the array
    // Time Complexity = O(N) --- even its O(n(n-1)/2)
    public int[] selectionSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[minIndex] > arr[j])
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Num Of Elements: ");
        int num = input.nextInt();

        int[] arr = new int[num];
        System.out.println("The Elements: ");
        for (int i = 0; i < num; i++)
            arr[i] = input.nextInt();

        SelectionSort obj = new SelectionSort();
        arr = obj.selectionSort(arr);
        for (int i = 0; i < num; i++)
            System.out.print(arr[i] + " ");
    }
}
