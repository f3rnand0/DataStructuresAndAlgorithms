package code.interview.sorting;

import java.util.Arrays;

public class BubbleSort {

    // Start checking if the first two numbers are ordered, if no swap them. Continue doing this
    // until assuring the array is ordered by setting a boolean only when a swapping has been
    // done on an iteration

    // Best: O(n) T, O(1) S
    // Average: O(n^2) T, O(1) S
    // Worst: O(n^2) T, O(1) S
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }
        boolean isSorted = false;
        int counter = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1 - counter; i++) {
                if (array[i] > array[i + 1]) {
                    swap(i, i + 1, array);
                    isSorted = false;
                }
            }
        }
        return array;
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        System.out.println(Arrays.toString(bubbleSort(numbers)));
    }

}
