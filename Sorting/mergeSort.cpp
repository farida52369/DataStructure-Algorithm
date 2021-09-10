#include <bits/stdc++.h>

// C++ PROGRAMMING LANGUAGE USES MERGE SORTING
// DIVIDE AND CONQUER TECHNIQUE IS APPLIED IN THIS ALGORITHM
// BREAKING DOWN BIG PROBLEM TO SMALLEST ONES

void merge(int arr[], int start, int mid, int end) {
  // LENGTH OF THE TWO SUBARRAYS
  int len_1 = mid - start + 1, len_2 = end - mid;
  int arr_1[len_1], arr_2[len_2];

  // GIVING DATA TO THE SUBARRAYS FROM ARR THE MOTHER
  for (int i = 0; i < len_1; i++) arr_1[i] = arr[start + i];
  for (int i = 0; i < len_2; i++) arr_2[i] = arr[mid + 1 + i];

  // STARTING POINT FOR ARR_1 AND ARR_2
  // THE RANGE WILL BE ORDERED IN THE ARR MOTHER
  // USING K INDEX AS A START
  int i = 0, j = 0, k = start;
  while (len_1 > i && len_2 > j) {
    if (arr_1[i] > arr_2[j])
      arr[k++] = arr_2[j++];
    else
      arr[k++] = arr_1[i++];
  }

  // CHECKING IF THEIR REMAIN ANY DATA
  // IN ARR_1 AND ARR_2 HAVEN'T ADDED YET
  while (len_1 > i) {
    arr[k++] = arr_1[i++];
  }

  while (len_2 > j) {
    arr[k++] = arr_2[j++];
  }
}

void mergeSort(int arr[], int start, int end) {
  if (start >= end) return;

  int mid = start + (end - start) / 2;

  // SPLITTING THE ARRAY TO THE SMALLEST PIECES
  mergeSort(arr, start, mid);
  mergeSort(arr, mid + 1, end);
  merge(arr, start, mid, end);
}

void printArr(int arr[], int N) {
  for (int i = 0; i < N; i++) std::cout << " " << std::setw(2) << arr[i] << " ";
  std::cout << '\n';
}

int main() {
  int N;
  std::cin >> N;

  int arr[N];
  for (int i = 0; i < N; i++) std::cin >> arr[i];

  mergeSort(arr, 0, N - 1);

  std::cout << "\nThe Sorted Array:\n";
  printArr(arr, N);
}
