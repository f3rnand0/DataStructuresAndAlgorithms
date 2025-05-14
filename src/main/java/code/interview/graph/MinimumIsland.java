package code.interview.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumIsland {

  // Iterate through every land in the grid, once L is found use DFT to find out
  // the size of the current island. Store the minimum value.
  // Also, if the first land is water, the size returned will be 0, make it the
  // minimum size. To avoid also check that size must be greater than zero (the
  // assumption is that at least an island of size 1 exists)
  // O(rows * columns) T
  // O(rows * columns) S
  public static int minimumIsland(List<List<String>> grid) {
    int minimumSize = Integer.MAX_VALUE;
    Set<String> visitedLand = new HashSet<>();
    for (int row = 0; row < grid.size(); row++) {
      for (int column = 0; column < grid.getFirst().size(); column++) {
        int size = exploreSize(grid, row, column, visitedLand);
        if (size > 0 && size < minimumSize) {
          minimumSize = size;
        }
      }
    }
    return minimumSize;
  }

  private static int exploreSize(List<List<String>> grid, int row, int column,
                                 Set<String> visitedLand) {
    boolean rowInbounds = (row >= 0 && row < grid.size());
    boolean columnInbounds = (column >= 0 && column < grid.getFirst().size());
    if (!rowInbounds || !columnInbounds) {
      return 0;
    }
    if (grid.get(row).get(column).equals("W") || visitedLand.contains(row + "," + column)) {
      return 0;
    }
    visitedLand.add(row + "," + column);
    int totalSize = 1;
    totalSize += exploreSize(grid, row + 1, column, visitedLand);
    totalSize += exploreSize(grid, row - 1, column, visitedLand);
    totalSize += exploreSize(grid, row, column + 1, visitedLand);
    totalSize += exploreSize(grid, row, column - 1, visitedLand);
    return totalSize;
  }

  public static void main(String[] args) {
    List<List<String>> grid =
        List.of(List.of("W", "L", "W", "W", "W"), List.of("W", "L", "W", "W", "W"),
                List.of("W", "W", "W", "L", "W"), List.of("W", "W", "L", "L", "W"),
                List.of("L", "W", "W", "L", "L"), List.of("L", "L", "W", "W", "W"));
    System.out.println(MinimumIsland.minimumIsland(grid));
    grid = List.of(List.of("L", "L", "L"), List.of("L", "L", "L"), List.of("L", "L", "L"));
    System.out.println(MinimumIsland.minimumIsland(grid));
    grid = List.of(List.of("L", "W", "W", "L", "W"), List.of("L", "W", "W", "L", "L"),
                   List.of("W", "L", "W", "L", "W"), List.of("W", "W", "W", "W", "W"),
                   List.of("W", "W", "L", "L", "L"));
    System.out.println(MinimumIsland.minimumIsland(grid));
  }
}
