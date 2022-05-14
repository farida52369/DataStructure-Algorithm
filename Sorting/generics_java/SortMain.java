
import java.util.Arrays;

public class SortMain {

    public static void main(String[] args) {

        // Wrapper class Integer as generic types work with objects
        Integer[] intArr = {47, 85, 62, 34, 7, 10, 92, 106, 2, 54};
        String[] strArr = {"Gamma", "Beta", "Delta", "Alpha", "Theta"};

        // new Bubble Instance __ Integer
        Sort<Integer> bubbleInt = new Bubble<>();
        bubbleInt.sort(intArr);
        System.out.println("Sorted array- " + Arrays.toString(intArr));

        // new Bubble Instance __ String
        Sort<String> bubbleStr = new Bubble<>();
        bubbleStr.sort(strArr);
        System.out.println("Sorted array- " + Arrays.toString(strArr));

        // new Merge Instance __ Integer
        Sort<Integer> mergeInt = new Merge<>();
        mergeInt.sort(intArr);
        System.out.println("Sorted array- " + Arrays.toString(intArr));

        // new Merge Instance __ String
        Sort<String> mergeStr = new Merge<>();
        mergeStr.sort(strArr);
        System.out.println("Sorted array- " + Arrays.toString(strArr));

        // new Insertion Instance __ Integer
        Sort<Integer> insertionInt = new Insertion<>();
        insertionInt.sort(intArr);
        System.out.println("Sorted array- " + Arrays.toString(intArr));

        // new Insertion Instance __ String
        Sort<String> insertionStr = new Insertion<>();
        insertionStr.sort(strArr);
        System.out.println("Sorted array- " + Arrays.toString(strArr));

    }
}
