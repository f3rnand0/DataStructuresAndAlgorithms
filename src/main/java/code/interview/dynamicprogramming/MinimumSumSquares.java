package code.interview.dynamicprogramming;

import java.util.HashMap;

public class MinimumSumSquares {

  // By subtracting from the 'n' number every perfect square that is equal or greater than
  // zero a tree can be formed where the number of edges is the number of sums of perfect
  // squares to get that number. Using recursion the base case would be when n is zero, then
  // the minimum sum is zero.
  // Also, a minimum must be determined to get the expected minimum sum. And for every
  // calculation of minimum square the count must be incremented by 1.
  // Using only integers isn't feasible because there are special cases like when n is a
  // perfect square, and it falls as if it would be the base case (n=0)
  // O( n * sqrt(n)) T // because the amount of perfect squares is dynamic, not only 2
  // O(n) S
  public static int minimumSumSquaresUsingMemo(int n) {
    return (int) minimumSumSquaresUsingMemo(n, new HashMap<>());
  }

  public static double minimumSumSquaresUsingMemo(int n, HashMap<Integer, Double> memo) {
    if (n < 0) {
      return Double.POSITIVE_INFINITY;
    }
    if (n == 0) {
      return 0.;
    }
    if (memo.containsKey(n)) {
      return memo.get(n);
    }
    double minSquares = Double.POSITIVE_INFINITY;
    for (int i = 1; i <= Math.sqrt(n); i += 1) {
      int square = i * i;
      double numSquares = 1 + minimumSumSquaresUsingMemo(n - square, memo);
      if (numSquares < minSquares) {
        minSquares = numSquares;
      }
    }
    memo.put(n, minSquares);
    return minSquares;
  }

  // O( sqrt(n) ^ n ) T // because the amount of perfect squares is dynamic, not only 2
  // O(n) S
  public static int minimumSumSquaresUsingBruteForce(int n) {
    if (n < 0) {
      return Integer.MAX_VALUE;
    }
    if (n == 0) {
      return 0;
    }
    int minSquares = Integer.MAX_VALUE;
    for (int i = 1; i <= Math.sqrt(n); i += 1) {
      int square = i * i;
      int numSquares = 1 + minimumSumSquaresUsingBruteForce(n - square);
      if (numSquares < minSquares) {
        minSquares = numSquares;
      }
    }
    return minSquares;
  }

  public static void main(String[] args) {
    System.out.println(MinimumSumSquares.minimumSumSquaresUsingBruteForce(9)); // 1
    System.out.println(MinimumSumSquares.minimumSumSquaresUsingBruteForce(31)); // 4
    // System.out.println(MinimumSumSquares.minimumSumSquaresUsingBruteForce(201)); // lasts forever
    System.out.println(MinimumSumSquares.minimumSumSquaresUsingMemo(9)); // 1
    System.out.println(MinimumSumSquares.minimumSumSquaresUsingMemo(31)); // 4
    System.out.println(MinimumSumSquares.minimumSumSquaresUsingMemo(201)); // 3
  }
}
