package code.interview.dynamicprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumPossible {

  // Use recursion by decreasing the amount from every number in the list. If
  // the amount is 0 it means the sum is possible, but if the number is negative
  // means the sum isn't possible.
  // Eventually the amount will become zero or negative, so it's not needed to
  // keep track of every result.
  // Use a HashMap to store the calculated sums of the corresponding amounts to
  // avoid a worse time complexity.
  // O(a*n) T (amount * size of numbers list
  // O(a) S
  public static boolean sumPossible(int amount, List<Integer> numbers) {
    return sumPossible(amount, numbers, new HashMap<>());
  }

  private static boolean sumPossible(int amount, List<Integer> numbers,
                                     Map<Integer, Boolean> memo) {
    if (amount == 0) {
      return true;
    }
    if (amount < 0) {
      return false;
    }
    if (memo.containsKey(amount)) {
      return memo.get(amount);
    }
    for (int num : numbers) {
      if (sumPossible(amount - num, numbers, memo)) {
        memo.put(amount, true);
        return true;
      }
    }
    memo.put(amount, false);
    return false;
  }

  public static void main(String[] args) {
    System.out.println(SumPossible.sumPossible(8, List.of(5, 12, 4)));
    System.out.println(SumPossible.sumPossible(15, List.of(6, 2, 10, 19)));
    System.out.println(SumPossible.sumPossible(0, List.of()));
    System.out.println(SumPossible.sumPossible(271, List.of(10, 8, 265, 24)));
  }
}
