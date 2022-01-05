
const binarySearch = (arr, left, right, x) => {
    if(left > right) return null;

    let mid = left + parseInt((right - left)/2); // Avoid overflow
    if(arr[mid] === x) return mid;
    if(arr[mid] > x) return binarySearch(arr, left, mid - 1, x);
    return binarySearch(arr, mid + 1, right, x);
}

console.log(binarySearch([1, 2, 3, 4, 5, 6, 7, 9, 100], 0, 8, 100))
console.log(binarySearch([1, 2, 3, 4, 5, 6, 7, 9, 100], 0, 8, 5))
// Return the index of the required number and null if the number isn't in the list
// The arr must be Sorted ...
//