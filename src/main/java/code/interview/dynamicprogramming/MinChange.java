package code.interview.dynamicprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinChange {

  // Use recursion where one of the base cases occurs when the amount is 0 (the number of
  // minimum coins is 0).
  // Another base case happens when the amount is negative. In this case the amount of coins
  // must be a positive infinitive to allow the minimum logic work correctly.
  // A minimum functionality is used to determine the minimum amount of coins needed for the
  // corresponding amount.
  // Also, it's important to increase by 1 every time the number of subCoins because it's the
  // child (in the decision tree) which we got when calling minCoins.
  // IMPORTANT: The minimum logic and the increment to the subCoins is done only when the
  // minChange isn't equal to -1. Otherwise, it'll increment by 1 the positive infinite
  // and will cause the minimum to be assigned to 0, which is wrong.
  //
  // O(c^a) T
  // O(a) S
  public static int minChangeBruteForce(int amount, List<Integer> coins) {
    if (amount == 0) {
      return 0;
    }
    if (amount < 0) {
      return -1;
    }

    int minCoins = -1;
    for (int coin : coins) {
      int subCoins = minChangeBruteForce(amount - coin, coins);
      if (subCoins != -1) {
        int numCoins = 1 + subCoins;
        if (numCoins < minCoins || minCoins == -1) {
          minCoins = numCoins;
        }
      }
    }
    return minCoins;
  }

  // Using the same algorithm as the brute force, use a HashMAP to store the amount and its
  // corresponding minCoins. This allows to work with bigger numbers and improves time
  // complexity
  // O(c*a) T
  // O(a) S
  public static int minChangeMemoization(int amount, List<Integer> coins) {
    return minChangeMemoization(amount, coins, new HashMap<>());
  }

  private static int minChangeMemoization(int amount, List<Integer> coins,
                                          Map<Integer, Integer> memo) {
    if (amount == 0) {
      return 0;
    }
    if (amount < 0) {
      return -1;
    }
    if (memo.containsKey(amount)) {
      return memo.get(amount);
    }

    int minCoins = -1;
    for (int coin : coins) {
      int subAmount = amount - coin;
      int subCoins = minChangeMemoization(subAmount, coins, memo);
      if (subCoins != -1) {
        int numCoins = 1 + subCoins;
        if (numCoins < minCoins || minCoins == -1) {
          minCoins = numCoins;
        }
      }
    }
    memo.put(amount, minCoins);
    return minCoins;
  }

  public static void main(String[] args) {
    System.out.println(MinChange.minChangeBruteForce(8, List.of(1, 5, 4, 12)));  // 2
    System.out.println(MinChange.minChangeBruteForce(7, List.of(2, 4, 6, 12)));  // -1
    //System.out.println(MinChange.minChangeBruteForce(102, List.of(1, 5, 10, 25))); // 6,
    // infinite recursion
    //System.out.println(MinChange.minChangeBruteForce(271, List.of(10, 8, 265, 24))); // -1
    // infinite recursion
    System.out.println(MinChange.minChangeMemoization(8, List.of(1, 5, 4, 12)));  // 2
    System.out.println(MinChange.minChangeMemoization(102, List.of(1, 5, 10, 25))); // 6
    System.out.println(MinChange.minChangeMemoization(271, List.of(10, 8, 265, 24))); // -1

  }
}
