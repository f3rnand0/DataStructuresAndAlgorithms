package code.interview.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinMaxStackConstruction {

    static class MinMaxStack {

        // List to store the min and max values of the stack at every push operation
        private List<Map<String, Integer>> minMaxStack = new ArrayList<>();

        // List to store the values of the stack
        private List<Integer> stack = new ArrayList<>();

        // O(1) T, O(1) S
        public int peek() {
            return stack.get(stack.size() - 1);
        }

        // Remove the values from the minMaxStack and stack structures

        // O(1) T, O(1) S
        public int pop() {
            minMaxStack.remove(minMaxStack.size() - 1);
            return stack.remove(stack.size() - 1);
        }

        // Create a map to store the new min and max values. Then check those values with the
        // current min and max values and add the correspondent to this newMinMaxMap. Finally,
        // add the new min and max values to the minMaxStack, and the new value to stack structures
        // O(1) T, O(1) S
        public void push(Integer number) {
            Map<String, Integer> newMinMax = new HashMap<>();
            newMinMax.put("min", number);
            newMinMax.put("max", number);
            if (minMaxStack.size() > 0) {
                Map<String, Integer> lastMinMax =
                    new HashMap<>(minMaxStack.get(minMaxStack.size() - 1));
                newMinMax.replace("min", Math.min(lastMinMax.get("min"), number));
                newMinMax.replace("max", Math.max(lastMinMax.get("max"), number));
            }
            minMaxStack.add(newMinMax);
            stack.add(number);
        }

        // O(1) T, O(1) S
        public int getMin() {
            return minMaxStack.get(minMaxStack.size() - 1).get("min");
        }

        // O(1) T, O(1) S
        public int getMax() {
            return minMaxStack.get(minMaxStack.size() - 1).get("max");
        }

    }

}
