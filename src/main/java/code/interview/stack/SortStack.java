package code.interview.stack;

import java.util.ArrayList;
import java.util.List;

public class SortStack {

    // Recursively pop every item of the stack until it's empty. While doing that keep the top
    // item in memory, and sort that item in the remaining stack. The sorting method
    // (insertInSortedOrder) will move the item to be ordered to the correct place. An empty
    // stack is already ordered
    // O(n^2) T
    // O(n) T
    public List<Integer> sortStack(ArrayList<Integer> stack) {
        if (stack.size() == 0) {
            return stack;
        }
        int top = stack.remove(stack.size() - 1);
        sortStack(stack);
        insertInSortedOrder(stack, top);
        return stack;
    }

    private void insertInSortedOrder(List<Integer> stack, int value) {
        if (stack.size() == 0 || stack.get(stack.size() - 1) <= value) {
            stack.add(value);
            return;
        }
        int top = stack.remove(stack.size() - 1);
        insertInSortedOrder(stack, value);
        stack.add(top);
    }

    public static void main(String[] args) {
        SortStack sortStack = new SortStack();
        System.out.println(sortStack.sortStack(new ArrayList<>(List.of(-5, 2, -2, 4, 3, 1))));
    }
}
