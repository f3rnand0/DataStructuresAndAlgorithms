package code.interview.dynamicprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxNonAdjacentSum {

  // The possible combinations of sublists with non-adjacent elements can be represented
  // as a binary tree. Where one node would be a list that include the current element (excluding
  // its adjacent number), and another node would be a list that exclude the current element.
  // Use an index to avoid creating slices of the original list. With the index the current element
  // is changed and every node can be calculated. Sum only to the first node the current value
  // Also, use a memo to store already calculated nodes.
  // O(n) T
  // O(n) S
  public static int maxNonAdjacentSumMemoization(List<Integer> numbers) {
    return maxNonAdjacentSumMemoization(numbers, 0, new HashMap<>());
  }

  private static int maxNonAdjacentSumMemoization(List<Integer> numbers, int index,
                                                  Map<Integer, Integer> memo) {
    if (index >= numbers.size()) {
      return 0;
    }
    if (memo.containsKey(index)) {
      return memo.get(index);
    }
    int include = numbers.get(index) + maxNonAdjacentSumMemoization(numbers, index + 2, memo);
    int exclude = maxNonAdjacentSumMemoization(numbers, index + 1, memo);
    int sum = Math.max(include, exclude);
    memo.put(index, sum);
    return sum;
  }

  // O (2^n) T
  // O (n) S
  public static int maxNonAdjacentSumBruteForce(List<Integer> numbers) {
    return maxNonAdjacentSumBruteForce(numbers, 0);
  }

  private static int maxNonAdjacentSumBruteForce(List<Integer> numbers, int index) {
    if (index >= numbers.size()) {
      return 0;
    }
    int include = numbers.get(index) + maxNonAdjacentSumBruteForce(numbers, index + 2);
    int exclude = maxNonAdjacentSumBruteForce(numbers, index + 1);
    return Math.max(include, exclude);
  }

  public static void main(String[] args) {
    List<Integer> numbers = List.of(2, 4, 5, 12, 7);
    System.out.println(MaxNonAdjacentSum.maxNonAdjacentSumBruteForce(numbers)); // 16
    System.out.println(MaxNonAdjacentSum.maxNonAdjacentSumMemoization(numbers)); // 16

    numbers = List.of(7, 5, 5, 12, 17, 29);
    System.out.println(MaxNonAdjacentSum.maxNonAdjacentSumBruteForce(numbers)); // 48
    System.out.println(MaxNonAdjacentSum.maxNonAdjacentSumMemoization(numbers)); // 48

    numbers =
        List.of(72, 62, 10, 6, 20, 19, 42, 46, 24, 78, 30, 41, 75, 38, 23, 28, 66, 55, 12, 17, 83,
                80, 56, 68, 6, 22, 56, 96, 77, 98, 61, 20, 0, 76, 53, 74, 8, 22, 92, 37, 30, 41, 75,
                38, 23, 28, 66, 55, 12, 17, 72, 62, 10, 6, 20, 19, 42, 46, 24, 78, 42);
    // System.out.println(MaxNonAdjacentSum.maxNonAdjacentSumBruteForce(numbers)); // lasts forever
    System.out.println(MaxNonAdjacentSum.maxNonAdjacentSumMemoization(numbers)); // 1465
  }
}
