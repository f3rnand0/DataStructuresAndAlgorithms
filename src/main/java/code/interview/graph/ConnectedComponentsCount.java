package code.interview.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConnectedComponentsCount {

  // A component is a semi-graph whose nodes are connected. A component can also be a
  // node without edges.
  // Iterate through all the nodes in the adjacency list. Then use DFT (BFT can be used
  // too) to find every component. Use a set to save the visited nodes, and avoid endless
  // loops or counting the same component again.
  // Also use a counter to count every component found.
  // O(e) T
  // O(n) S
  public static int connectedComponentsCount(Map<Integer, List<Integer>> graph) {
    Set<Integer> visitedNodes = new HashSet<>();
    int count = 0;
    for (Integer node : graph.keySet()) {
      if (traverseComponent(graph, node, visitedNodes)) {
        count++;
      }
    }
    return count;
  }

  private static boolean traverseComponent(Map<Integer, List<Integer>> graph, Integer source,
                                           Set<Integer> visitedNodes) {
    if (visitedNodes.contains(source)) {
      return false;
    }
    visitedNodes.add(source);
    for (Integer node : graph.get(source)) {
      traverseComponent(graph, node, visitedNodes);
    }
    return true;
  }

  public static void main(String[] args) {
    Map<Integer, List<Integer>> graph =
        Map.of(0, List.of(8, 1, 5), 1, List.of(0), 5, List.of(0, 8), 8, List.of(0, 5), 2,
               List.of(3, 4), 3, List.of(2, 4), 4, List.of(3, 2));
    System.out.println(ConnectedComponentsCount.connectedComponentsCount(graph));  // -> 2
    graph =
        Map.of(3, List.of(), 4, List.of(6), 6, List.of(4, 5, 7, 8), 8, List.of(6), 7, List.of(6), 5,
               List.of(6), 1, List.of(2), 2, List.of(1));
    System.out.println(ConnectedComponentsCount.connectedComponentsCount(graph));
  }
}
