package code.interview.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalancedBracket {

    // Using a stack to store the opening brackets and remove them as the closing corresponding
    // brackets appear. Also use a map to store the opening brackets and its correspondent
    // closing ones. Must consider the case where the stack is empty but there are still closing
    // brackets to be checked, also the case where opening brackets overlap with other non-related
    // closing brackets, and after iterating all the letters to check if the stack is empty.
    // O(n) T
    // O(n) S
    public boolean balancedBrackets(String str) {
        String openingBrackets = "([{";
        String closingBrackets = ")]}";
        Map<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put(']', '[');
        matchingBrackets.put('}', '{');
        List<Character> stack = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (openingBrackets.indexOf(letter) != -1) {
                stack.add(letter);
            } else if (closingBrackets.indexOf(letter) != -1) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.get(stack.size() - 1) == matchingBrackets.get(letter)) {
                    stack.remove(stack.size() - 1);
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        BalancedBracket balancedBracket = new BalancedBracket();
        System.out.println(balancedBracket.balancedBrackets("([])(){}(())()()"));
        System.out.println(balancedBracket.balancedBrackets("([(])()()"));
    }
}
