package code.interview.dynamicprogramming;

import java.util.HashMap;
import java.util.List;

public class CountingChange {

  // Generate a tree where the amount is the root node. Then, start subtracting from the amount
  // every coin multiplied n times until the result is 0 or greater than zero. When the result
  // is zero, means that a change can be obtained with that coin(s). So add 1 to the a counter
  // variable. Also use an index variable to navigate through the list of coins.
  // For the recursion the bases cases would be when the amount is 0 and once the index is equal
  // to the list size
  // Also, use a memo to store already calculated changes.
  // O(amount * coins) T
  // O(amount * coins) S
  public static int countingChangeUsingMemoization(int amount, List<Integer> coins) {
    return countingChangeUsingMemoization(amount, 0, coins, new HashMap<>());
  }

  public static int countingChangeUsingMemoization(int amount, int coinIndex, List<Integer> coins,
                                                   HashMap<List<Integer>, Integer> memo) {
    if (amount == 0) {
      return 1;
    }
    if (coinIndex == coins.size()) {
      return 0;
    }

    List<Integer> key = List.of(amount, coinIndex);
    if (memo.containsKey(key)) {
      return memo.get(key);
    }

    int total = 0;
    for (int quantity = 0; quantity * coins.get(coinIndex) <= amount; quantity++) {
      int subAmount = amount - (quantity * coins.get(coinIndex));
      total += countingChangeUsingMemoization(subAmount, coinIndex + 1, coins, memo);
    }
    memo.put(key, total);
    return total;
  }

  // O(amount ^ coins) T
  // O(coins) S
  public static int countingChangeUsingBruteForce(int amount, List<Integer> coins) {
    return countingChangeUsingBruteForce(amount, 0, coins);
  }

  private static int countingChangeUsingBruteForce(int amount, int coinIndex, List<Integer> coins) {
    if (amount == 0) {
      return 1;
    }
    if (coinIndex == coins.size()) {
      return 0;
    }

    int total = 0;
    for (int quantity = 0; quantity * coins.get(coinIndex) <= amount; quantity += 1) {
      int subAmount = amount - (quantity * coins.get(coinIndex));
      total += countingChangeUsingBruteForce(subAmount, coinIndex + 1, coins);
    }

    return total;
  }

  public static void main(String[] args) {
    System.out.println(CountingChange.countingChangeUsingBruteForce(4, List.of(1, 2, 3))); // 4
    System.out.println(
        CountingChange.countingChangeUsingBruteForce(13, List.of(2, 6, 12, 10))); // 0
    //System.out.println(CountingChange.countingChangeUsingBruteForce(240,
    //                                                                List.of(1, 2, 3, 4, 5, 6,
    //                                                                7, 8,
    //                                                                        9))); // lasts forever
    System.out.println(CountingChange.countingChangeUsingMemoization(4, List.of(1, 2, 3))); // 4
    System.out.println(
        CountingChange.countingChangeUsingMemoization(13, List.of(2, 6, 12, 10))); // 0
    System.out.println(CountingChange.countingChangeUsingMemoization(240,
                                                                     List.of(1, 2, 3, 4, 5, 6, 7, 8,
                                                                             9))); // 1525987916
  }
}
