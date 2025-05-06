package code.interview.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IslandCount {

  // Iterate through the grid graph using rows and columns. Once a L is found, run a depth
  // first traversal to find the rest of adjacent land. Store every land in a set structure
  // to avoid infinite recursion and counting an island again.
  // Also, when using DFS consider the 4 neighbors of the current element (one row up, one
  // row down, one column left, one column right). And the DFS ends when a W element has
  // been found.
  // O(rows * columns) T
  // O(rows * columns) S
  public static int islandCount(List<List<String>> grid) {
    int islands = 0;
    Set<String> visitedNodes = new HashSet<>();
    for (int row = 0; row < grid.size(); row++) {
      for (int column = 0; column < grid.get(row).size(); column++) {
        if (explore(grid, row, column, visitedNodes)) {
          islands++;
        }
      }
    }
    return islands;
  }

  private static boolean explore(List<List<String>> grid, int row, int column,
                              Set<String> visitedNodes) {
    boolean rowInbounds = (row >=0 && row < grid.size());
    boolean columnInbounds = (column >=0 && column < grid.getFirst().size());
    if (!rowInbounds || !columnInbounds) {
      return false;
    }
    if (grid.get(row).get(column).equals("W") || visitedNodes.contains(row + "," + column)) {
      return false;
    }
    visitedNodes.add(row + "," + column);
    explore(grid, row + 1, column, visitedNodes);
    explore(grid, row - 1, column, visitedNodes);
    explore(grid, row, column + 1, visitedNodes);
    explore(grid, row, column - 1, visitedNodes);
    return true;
  }

  public static void main(String[] args) {
    List<List<String>> grid =
        List.of(List.of("W", "L", "W", "W", "W"), List.of("W", "L", "W", "W", "W"),
                List.of("W", "W", "W", "L", "W"), List.of("W", "W", "L", "L", "W"),
                List.of("L", "W", "W", "L", "L"), List.of("L", "L", "W", "W", "W"));
    System.out.println(islandCount(grid));
    grid = List.of(List.of("L", "W", "W", "L", "W"), List.of("L", "W", "W", "L", "L"),
            List.of("W", "L", "W", "L", "W"), List.of("W", "W", "W", "W", "W"),
            List.of("W", "W", "L", "L", "L"));
    System.out.println(islandCount(grid));
  }
}
