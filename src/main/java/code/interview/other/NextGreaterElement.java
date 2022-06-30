package code.interview.other;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    // The brute force approach iterates the array entirely (in a circular way) until the previous
    // element of item being checked.
    // By iterating two times the array and using stack to store the indexes of the next
    // greater elements. Initially store indexes in the stack whose values are less than the current
    // value of 'idx', and when the value at index 'idx' is greater than the peek of the stack start
    // storing in the result array values at the same indexes that the stack contains until it's
    // empty. Continue doing that until the end of the two iterations. Most of the values of the
    // result array will be modified twice.
    // O(n) T
    // O(n) S
    public int[] nextGreaterElementUsingStack1(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int idx = 0; idx < 2 * array.length; idx++) {
            int circularIdx = idx % array.length;

            while (!stack.isEmpty() && array[stack.peek()] < array[circularIdx]) {
                int top = stack.pop();
                result[top] = array[circularIdx];
            }
            stack.push(circularIdx);
        }

        return result;
    }

    // It shares the same approach as the algorithm above but it iterates in reverse mode the array.
    // Also, the value is added to the stack (not the index) and elements of stack are popped out
    // when they are less than or equal to the current array value
    // O(n) T
    // O(n) S
    public int[] nextGreaterElementUsingStack2(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int idx = 2 * array.length - 1; idx >= 0; idx--) {
            int circularIdx = idx % array.length;

            while (!stack.isEmpty()) {
                if (stack.peek() <= array[circularIdx]) {
                    stack.pop();
                } else {
                    result[circularIdx] = stack.peek();
                    break;
                }
            }

            stack.push(array[circularIdx]);
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        System.out.println(Arrays.toString(
            nextGreaterElement.nextGreaterElementUsingStack1(new int[]{2, 5, -3, -4, 6, 7, 2})));
        System.out.println(Arrays.toString(
            nextGreaterElement.nextGreaterElementUsingStack2(new int[]{2, 5, -3, -4, 6, 7, 2})));
    }
}
