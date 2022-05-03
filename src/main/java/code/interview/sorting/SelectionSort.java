package code.interview.sorting;

import java.util.Arrays;

public class SelectionSort {

    // In every iteration find the smallest number but ommiting an index until this index is the
    // second last item of the array

    // Best: O(n^2) T, O(1) S
    // Average:  O(n^2) T, O(1) S
    // Worst:  O(n^2) T, O(1) S
    public static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }
        int startIdx = 0;
        while (startIdx < array.length - 1) {
            int smallestIdx = startIdx;
            for (int i = startIdx+1; i < array.length; i++) {
                if (array[smallestIdx] > array[i]) {
                    smallestIdx = i;
                }
            }
            int temp = array[smallestIdx];
            array[smallestIdx] = array[startIdx];
            array[startIdx] = temp;
            startIdx++;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        System.out.println(Arrays.toString(SelectionSort.selectionSort(numbers)));
    }
}
