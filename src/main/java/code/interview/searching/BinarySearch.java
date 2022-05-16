package code.interview.searching;

public class BinarySearch {

    // In binary-search the elements must be sorted. If they are unsorted, first sort them.
    // Consists of dividing the sample in half every time. The low or high half is chosen by
    // defining if the number searched is lower or greater than the mid-number

    // O(log(n) T
    // O(1) S
    public int binarySearch(int[] array, int target) {
        int first = 0;
        int last = array.length - 1;
        int middle;
        int potentialMatch;
        while (first <= last) {
            middle = (first + last) / 2;
            potentialMatch =  array[middle];
            if (target == potentialMatch) {
                return middle;
            } else if (target < potentialMatch) {
                last = middle - 1;
            } else {
                first = middle + 1;
            }
        }
        return -1;
    }

    public int binarySearchRecursive(int[] array, int target) {
        return binarySearchRecursive(array, target, 0, array.length - 1);
    }

    private int binarySearchRecursive(int[] array, int target, int first, int last) {
        if (first > last) {
            return -1;
        }
        int middle = (first + last) / 2;
        int potentialMatch = array[middle];
        if (target == potentialMatch) {
            return middle;
        } else if (target < potentialMatch) {
            return binarySearchRecursive(array, target, first, middle - 1);
        } else {
            return binarySearchRecursive(array, target, middle + 1, last);
        }
    }


    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] array = {10, 25, 32, 45, 55, 68};
        System.out.println("Element found at index " + bs.binarySearch(array, 55));
        System.out.println("Element found at index " + bs.binarySearch(array, 100));
        System.out.println("Element found at index " + bs.binarySearchRecursive(array, 55));
        System.out.println("Element found at index " + bs.binarySearchRecursive(array, 100));
    }
}