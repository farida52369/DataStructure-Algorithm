#include <bits/stdc++.h>

/**
 * I MADE IT AS SIMPLE AS I CAN SO I PREFERED NOT TO USE HEADERS OR SEPERATED CLASSES FOR EACH SORT TYPE  
 * Tried To Stick To The Shape of Interface Sort<T>
 */
template <typename T> class Sort
{
public:
    virtual void sort_(T arr[], int n) = 0;
};

/**
 * Bubble Sort inherit from abstract class Sort
 *
 * implement (sort) function and must be implemented
 * as it's initialized in Sort class as virtual = 0;
 * Generics for any provided type T
 */
template <typename T> class Bubble: public Sort<T>
{
public:
    void sort_(T arr[], int n)
    {
        for (int i = 0; i < n - 1; i++)
            for (int j = n - 1; i < j; j--)
                if (arr[j] < arr[j - 1])
                    std::swap(arr[j], arr[j - 1]);

    }
};

/**
 * Merge Sort inherit from abstract class Sort
 */
template <typename T> class Merge: public Sort<T>
{
public:
    void sort_(T arr[], int n)
    {
        merge_(arr, 0, n - 1);
    }

    void merge_(T arr[], int left, int right)
    {
        if (left < right)
        {
            int mid = left + (right - left) / 2;
            merge_(arr, left, mid);
            merge_(arr, mid + 1, right);
            merge_(arr, left, mid, right);
        }
    }

    void merge_(T arr[], int left, int mid, int right)
    {
        int len_1 = mid - left + 1, len_2 = right - mid, i;

        T arr_1[len_1], arr_2[len_2];

        for (i = 0; i < len_1; i++) arr_1[i] = arr[left + i];
        for (i = 0; i < len_2; i++) arr_2[i] = arr[mid + 1 + i];

        i = 0;
        int k = left, j = 0;

        while (i < len_1 && j < len_2)
            if (arr_1[i] > arr_2[j]) arr[k++] = arr_2[j++];
            else arr[k++] = arr_1[i++];

        while (i < len_1) arr[k++] = arr_1[i++];
        while (j < len_2) arr[k++] = arr_2[j++];
    }

};

/**
 * Insertion Sort inherit from abstract class Sort
 */
template <typename T> class Insertion: public Sort<T>
{
public:
    void sort_(T arr[], int n)
    {
        for (int i = 1; i < n; i++)
        {
            T key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = key;
        }
    }
};

/**
 * (print array) function to display the array for the user in the terminal
 */
template <typename T> void print_array(T a[], int n)
{
    std::cout << "Sorted array- ";
    for (int i = 0; i < n; i++)
        std::cout << a[i] << " ";
    std::cout << std::endl;
}

int main()
{
    // Pointers for the interface Sort
    // from types Integer, and String
    Sort<int>* sort_integer;
    Sort<std::string>* sort_string;

    // Data Need To Be Sorted
    int intArr[] = {47, 85, 62, 34, 7, 10, 92, 106, 2, 54};
    std::string strArr[] = {"Gamma", "Beta", "Delta", "Alpha", "Theta"};
    int nI = sizeof(intArr) / sizeof(intArr[0]);
    int nS = sizeof(strArr) / sizeof(strArr[0]);

    // new Bubble Instance __ Integer
    Bubble<int> bubbleInt;
    sort_integer = &bubbleInt;
    sort_integer->sort_(intArr, nI);
    print_array<int>(intArr, nI);

    // new Bubble Instance __ String
    Bubble<std::string> bubbleStr;
    sort_string = &bubbleStr;
    sort_string->sort_(strArr, nS);
    print_array(strArr, nS);

    // new Merge Instance __ Integer
    Merge<int> mergeInt;
    sort_integer = &mergeInt;
    sort_integer->sort_(intArr, nI);
    print_array<int>(intArr, nI);

    // new Merge Instance __ String
    Merge<std::string> mergeStr;
    sort_string = &mergeStr;
    sort_string->sort_(strArr, nS);
    print_array<std::string>(strArr, nS);

    // new Insertion Instance __ Integer
    Insertion<int> insertionInt;
    sort_integer = &insertionInt;
    sort_integer->sort_(intArr, nI);
    print_array<int>(intArr, nI);

    // new Insertion Instance __ String
    Insertion<std::string> insertionStr;
    sort_string = &insertionStr;
    sort_string->sort_(strArr, nS);
    print_array<std::string>(strArr, nS);
    return 0;
}

