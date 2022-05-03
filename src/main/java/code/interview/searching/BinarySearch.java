package code.interview.searching;

public class BinarySearch {

    // In binary-search the elements must be sorted. If they are unsorted, first sort them.
    // Consists of dividing the sample in half every time. The low of igh half are chosen
    // by defining if the number to be looked at is lower or greater than that half

    // O(log(n) T
    // O(1) S
    public String binarySearch(int[] arr, int key) {
        int first = 0;
        int last = arr.length - 1;
        int mid = (first + last) / 2;

        while (first <= last) {
            if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] == key) {
                return "Element Found At Index " + mid;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        return "Element Not Found";
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] array = {10, 25, 32, 45, 55, 68};
        String result = bs.binarySearch(array, 55);
        System.out.println(result);
        String result2 = bs.binarySearch(array, 100);
        System.out.println(result2);
    }
}
