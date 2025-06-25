package code.interview.dynamicprogramming;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MaxPathSum {

  // The process of going to the right or down can be diagrammed in a binary tree. In that
  // sense, the current position (row + col) can be stored and in every node the biggest value
  // can be selected and then summed up to the current node value.
  // Iterating through the list and checking which of the nodes has a higher value, the max
  // sum can be found. The base case would be when being in the last child node where the value
  // returned would be the value of the child.
  // Finally, a memo can be used to store already calculated sums to avoid recalculating sums
  // O( r*c ) T
  // O( r*c ) S
  public static int maxPathSumMemoization(List<List<Integer>> grid) {
    return maxPathSumMemoization(grid, 0, 0, new HashMap<>());
  }

  private static int maxPathSumMemoization(List<List<Integer>> grid, int row, int column,
                                           Map<Map.Entry<Integer, Integer>, Integer> memo) {
    int rows = grid.size() - 1;
    int columns = grid.getFirst().size() - 1;
    if (row > rows || column > columns) {
      return Integer.MIN_VALUE;
    }
    if (row == rows && column == columns) {
      return grid.get(row).get(column);
    }
    AbstractMap.SimpleEntry<Integer, Integer> key = new AbstractMap.SimpleEntry<>(row, column);
    if (memo.containsKey(key)) {
      return memo.get(key);
    }
    int sumA = maxPathSumMemoization(grid, row + 1, column, memo);
    int sumB = maxPathSumMemoization(grid, row, column + 1, memo);
    int sum = grid.get(row).get(column) + Math.max(sumA, sumB);
    memo.put(new AbstractMap.SimpleEntry<>(row, column), sum);
    return sum;

  }

  // O ( 2^(r+c) ) T
  // O (r+c) S
  public static int maxPathSumBruteForce(List<List<Integer>> grid) {
    return maxPathSumBruteForce(grid, 0, 0);
  }

  private static int maxPathSumBruteForce(List<List<Integer>> grid, int row, int column) {
    int rows = grid.size() - 1;
    int columns = grid.getFirst().size() - 1;
    if (row > rows || column > columns) {
      return Integer.MIN_VALUE;
    }
    if (row == rows && column == columns) {
      return grid.get(row).get(column);
    }

    int sumA = maxPathSumBruteForce(grid, row + 1, column);
    int sumB = maxPathSumBruteForce(grid, row, column + 1);
    return grid.get(row).get(column) + Math.max(sumA, sumB);
  }

  public static void main(String[] args) {
    List<List<Integer>> grid = List.of(List.of(1, 3, 12), List.of(5, 1, 1), List.of(3, 6, 1));
    System.out.println(MaxPathSum.maxPathSumBruteForce(grid)); // 18
    System.out.println(MaxPathSum.maxPathSumMemoization(grid)); // 18

    grid = List.of(List.of(1, 2, 8, 1), List.of(3, 10, 12, 10), List.of(4, 0, 6, 3));
    System.out.println(MaxPathSum.maxPathSumBruteForce(grid)); // 39
    System.out.println(MaxPathSum.maxPathSumMemoization(grid)); // 39

    grid = List.of(List.of(1, 1, 3, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1),
                   List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                   List.of(1, 2, 1, 1, 6, 1, 1, 5, 1, 1, 0, 0, 1),
                   List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                   List.of(1, 1, 1, 5, 1, 1, 1, 1, 0, 1, 1, 1, 1),
                   List.of(2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                   List.of(2, 1, 1, 1, 1, 8, 1, 1, 1, 1, 1, 1, 1),
                   List.of(2, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                   List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                   List.of(1, 1, 1, 1, 1, 1, 1, 9, 1, 1, 1, 1, 1),
                   List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                   List.of(1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                   List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 1, 1, 1),
                   List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                   List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                   List.of(1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                   List.of(1, 42, 1, 1, 1, 1, 1, 1, 1, 8, 1, 1, 1),
                   List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                   List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
    System.out.println(MaxPathSum.maxPathSumBruteForce(grid)); // 82
    System.out.println(MaxPathSum.maxPathSumMemoization(grid)); // 82
  }
}
