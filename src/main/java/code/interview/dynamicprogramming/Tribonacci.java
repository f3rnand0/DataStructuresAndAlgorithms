package code.interview.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Tribonacci {

  // O(3^n) T
  // O(n) S
  public static int tribonacciBruteForce(int n) {
    if (n == 0 || n == 1) {
      return 0;
    }
    if (n == 2) {
      return 1;
    }
    return tribonacciBruteForce(n - 1) + tribonacciBruteForce(n - 2) + tribonacciBruteForce(n - 3);
  }

  // Use the same algorithm as the brute force. Also, use a HashMap the store values
  // already calculated. Check if the value was already calculated (exists in the
  // HashMap) before doing the calculation.
  // O(n) T
  // O(n) S
  public static int tribonacciMemoization(int n) {
    return tribonacciMemoization(n, new HashMap<>());
  }

  public static int tribonacciMemoization(int n, Map<Integer, Integer> memo) {
    if (n == 0 || n == 1) {
      return 0;
    }
    if (n == 2) {
      return 1;
    }
    if (memo.containsKey(n)) {
      return memo.get(n);
    }
    int result = tribonacciMemoization(n - 1, memo) + tribonacciMemoization(n - 2, memo) +
                 tribonacciMemoization(n - 3, memo);
    memo.put(n, result);
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Tribonacci.tribonacciBruteForce(0));
    System.out.println(Tribonacci.tribonacciBruteForce(5));
    System.out.println(Tribonacci.tribonacciBruteForce(7));
    System.out.println(Tribonacci.tribonacciBruteForce(37)); // takes too much
    System.out.println(Tribonacci.tribonacciMemoization(0));
    System.out.println(Tribonacci.tribonacciMemoization(5));
    System.out.println(Tribonacci.tribonacciMemoization(7));
    System.out.println(Tribonacci.tribonacciMemoization(20)); // 35890
    System.out.println(Tribonacci.tribonacciMemoization(37)); // 1132436852
  }
}
