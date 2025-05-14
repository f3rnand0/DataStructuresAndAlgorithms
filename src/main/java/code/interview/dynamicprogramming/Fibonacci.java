package code.interview.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

  // O(2^n) T
  // O(n) S (only n elements are put in the call stack)
  public static int fibBruteForce(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    return fibBruteForce(n - 1) + fibBruteForce(n - 2);
  }

  // Use the same algorithm as the brute force. Also, use a HashMap the store values
  // already calculated. Check if the value was already calculated (exists in the
  // HashMap) before doing the calculation.
  // O(n) T
  // O(n) S
  public static int fibMemoization(int n) {
    return fibMemoization(n, new HashMap<>());
  }

  private static int fibMemoization(int n, Map<Integer, Integer> memo) {
    if (n == 0 || n == 1) {
      return n;
    }
    if (memo.containsKey(n)) {
      return memo.get(n);
    }
    int result = fibMemoization(n - 1, memo) + fibMemoization(n - 2, memo);
    memo.put(n, result);
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Fibonacci.fibBruteForce(5));
    System.out.println(Fibonacci.fibBruteForce(6));
    System.out.println(Fibonacci.fibBruteForce(48)); // takes too much
    System.out.println(Fibonacci.fibMemoization(5));
    System.out.println(Fibonacci.fibMemoization(6));
    System.out.println(Fibonacci.fibMemoization(35)); // 9227465
    System.out.println(Fibonacci.fibMemoization(46)); // 1836311903
    System.out.println(Fibonacci.fibMemoization(48)); // 512559680 (doesn't fit in int type)
  }
}
