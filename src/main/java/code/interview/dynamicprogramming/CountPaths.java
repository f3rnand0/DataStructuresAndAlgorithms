package code.interview.dynamicprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountPaths {

  // Implement a decision tree where every node has a position of the grid. Iterate through
  // the grid until the bottom right is reached.
  // The base cases are when the row or column are out of bounds (return 0), when there's a
  // wall (return 0), and when the current position is the bottom left (return 1)
  // Sum every countPath call, that consists of increasing only row by 1 or increasing only
  // the column by 1
  // O(2^(r+c)) T
  // O(r+c) S (maximum recursion stack size)
  public static int countPathsBruteForce(List<List<String>> grid) {
    return countPathsBruteForce(grid, 0, 0);
  }

  private static int countPathsBruteForce(List<List<String>> grid, int r, int c) {
    if (r == grid.size() || c == grid.getFirst().size()) {
      return 0;
    }

    if (grid.get(r).get(c).equals("X")) {
      return 0;
    }

    if (r == grid.size() - 1 && c == grid.getFirst().size() - 1) {
      return 1;
    }

    return countPathsBruteForce(grid, r + 1, c) + countPathsBruteForce(grid, r, c + 1);
  }

  // Use the same algorithm, but use a HashMap to store paths that have already been
  // calculated. The key of the map is a List of the row and column.
  // Check if the key is already present in the map. Store the result in the map after
  // calculating the paths
  // O(r*c) T
  // O(r*c) S (maximum memo size)
  public static int countPathsMemoization(List<List<String>> grid) {
    return countPathsMemoization(grid, 0, 0, new HashMap<>());
  }

  public static int countPathsMemoization(List<List<String>> grid, int r, int c,
                                          Map<List<Integer>, Integer> memo) {
    if (r == grid.size() || c == grid.getFirst().size()) {
      return 0;
    }

    if (grid.get(r).get(c).equals("X")) {
      return 0;
    }

    if (r == grid.size() - 1 && c == grid.getFirst().size() - 1) {
      return 1;
    }

    List<Integer> pos = List.of(r, c);
    if (memo.containsKey(pos)) {
      return memo.get(pos);
    }

    int result =
        countPathsMemoization(grid, r + 1, c, memo) + countPathsMemoization(grid, r, c + 1, memo);
    memo.put(pos, result);
    return result;
  }

  public static void main(String[] args) {
    List<List<String>> grid = List.of(List.of("O", "O"), List.of("O", "O"));
    System.out.println(CountPaths.countPathsBruteForce(grid)); // 2
    System.out.println(CountPaths.countPathsMemoization(grid)); // 2
    grid = List.of(List.of("O", "O", "X"), List.of("O", "O", "O"), List.of("O", "O", "O"));
    System.out.println(CountPaths.countPathsBruteForce(grid)); // 5
    System.out.println(CountPaths.countPathsMemoization(grid)); // 5
    grid = List.of(List.of("O", "O", "X", "O", "O", "O"), List.of("O", "O", "O", "O", "O", "X"),
                   List.of("X", "O", "O", "O", "O", "O"), List.of("X", "X", "X", "O", "O", "O"),
                   List.of("O", "O", "O", "O", "O", "X"));
    System.out.println(CountPaths.countPathsBruteForce(grid)); // 0
    System.out.println(CountPaths.countPathsMemoization(grid)); // 0
    grid =
        List.of(List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
                        "O")); // 145422675
    System.out.println(CountPaths.countPathsBruteForce(grid));
    System.out.println(CountPaths.countPathsMemoization(grid));
  }
}
