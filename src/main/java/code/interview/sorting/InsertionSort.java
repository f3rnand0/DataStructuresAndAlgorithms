package code.interview.sorting;

public class InsertionSort {

    // Basically it inserts every number (except the first one) into a tentatively sorted array.
    // This sorted array starts with one element, the first one. So, at the beginning compares
    // the first and second numbers and orders them. Then does the same with the next numbers by
    // comparing them with this imaginary sorted array

    // Best: O(n) T, O(1) S
    // Average: O(n^2) T, O(1) S
    // Worst: O(n^2) T, O(1) S
    public int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }
        for (int i = 0; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                swap(j, j - 1, array);
                j = -1;
            }
        }
        return array;
    }

    private void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        InsertionSort insertionSort = new InsertionSort();
        System.out.println(insertionSort.insertionSort(numbers));
    }
}
