package code.interview.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LargestComponent {

  // A component is a semi-graph whose nodes are connected. A component can also be a
  // node without edges.
  // Iterate the graph using DFT. Store the current largest component size in a variable.
  // Also use a Set structure to store the vised nodes and avoid infinite loop issues.
  // To count every component use a count variable that starts with 1 because the current
  // node is already counted. Then the total count is obtained by visiting all the node's
  // neighbors and its neighbors' too.
  // O(e) T
  // O(n) S
  public static int largestComponent(Map<Integer, List<Integer>> graph) {
    Set<Integer> visited = new HashSet<>();
    int maxSize = 0;
    for (int node : graph.keySet()) {
      int size = traverseSize(graph, node, visited);
      if (size > maxSize) {
        maxSize = size;
      }
    }
    return maxSize;
  }

  private static int traverseSize(Map<Integer, List<Integer>> graph, Integer node,
                                  Set<Integer> visitedNodes) {
    if (visitedNodes.contains(node)) {
      return 0;
    }
    visitedNodes.add(node);
    int count = 1;
    for (int neighbor : graph.get(node)) {
      count += traverseSize(graph, neighbor, visitedNodes);
    }
    return count;
  }

  public static void main(String[] args) {
    Map<Integer, List<Integer>> graph =
        Map.of(0, List.of(8, 1, 5), 1, List.of(0), 5, List.of(0, 8), 8, List.of(0, 5), 2,
               List.of(3, 4), 3, List.of(2, 4), 4, List.of(3, 2));
    System.out.println(LargestComponent.largestComponent(graph));
    graph =
        Map.of(1, List.of(2), 2, List.of(1, 8), 6, List.of(7), 9, List.of(8), 7, List.of(6, 8), 8,
               List.of(9, 7, 2));
    System.out.println(LargestComponent.largestComponent(graph));
  }
}
