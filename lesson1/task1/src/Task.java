//SOURCES: https://www.geeksforgeeks.org/java-program-for-quicksort/
// found structure and process of the code

import java.util.Arrays;

public class Task {
  //put your task here
    public static void main(String[] args) {
        System.out.println("will sort array");
        int[] arr = {1, 3, 5, 99, 13, 39, 200, 3, 32, 0, 4, 44};  // array that will be sorted
        //print out sorted list Arrays.toString just allows the array to be displayed easily
        System.out.println(Arrays.toString(arr));  // print unsorted
        System.out.println(Arrays.toString(quickSort(arr, 0, arr.length - 1)));
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if(left < right) {  // break if they are the same, meaning array of 1
            int pivot = partition(arr, left, right);  // get pivot and sort array
            quickSort(arr, left, pivot - 1); // divide into low and high parts
            quickSort(arr, pivot + 1, right); // recursively sort
        }
        return arr;
    }
    public static int[] swap(int[] arr, int i, int j) { // swap array value positions
        int temp = arr[i]; // create temp value
        arr[i] = arr[j];  // replace value
        arr[j] = temp; // finish swap
        return arr;
    }
    // create a pivot and put all values lower than pivot to the left and higher to the right
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1; // index of smaller element
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {  // if element smaller or equal to pivot sort
                i++; // advance index
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);  // swap last high value with pivot
        printTest(arr, left, right);  // print out array for testing
        return i + 1;  // return index of pivot
        // array as passed as a reference so it is changed without being returned
    }
    public static void printTest(int[] arr, int left, int right){
        for(int i = left; i <= right; i++) {  // will print out section of array
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
/*
Testing: I tested the code by using multiple arrays and then printing out each step of the sort process
I then looked through the print-out and confirmed that the array was sorted correctly
[6, 3, 2, 6, 7, 3, 1, 0, 9, 8, 2]
2 1 0 2 7 3 3 6 9 8 6
0 1 2
1 2
3 3 6 6 9 8 7
3 3 6
3 3
7 8 9
8 9
[0, 1, 2, 2, 3, 3, 6, 6, 7, 8, 9]

[7, 6, 4, 3, 2, 0, 0]
0 0 4 3 2 7 6
4 3 2 6 7
2 3 4
3 4
[0, 0, 2, 3, 4, 6, 7]

[1, 3, 5, 99, 13, 39, 200, 3, 32, 0, 4, 44]
1 3 5 13 39 3 32 0 4 44 200 99
1 3 3 0 4 5 32 13 39
0 3 3 1
1 3 3
3 3
5 32 13 39
5 13 32
99 200
[0, 1, 3, 3, 4, 5, 13, 32, 39, 44, 99, 200]
 */