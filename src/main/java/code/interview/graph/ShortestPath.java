package code.interview.graph;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestPath {

  // A DFT isn't optimal because it would find the nodeB without using the shortest path. A BFT
  // is the only feasible option.
  // Use a queue to iterate in a BFT manner. The queue will contain the node and the current
  // distance. The distance must be incremented once a new node is visited.
  // The shortest path will always be once the current node if equal to nodeB because the BFT
  // assures that.
  // Because it's an undirected graph a set to store the visited nodes is also needed.
  // O(e) T
  // O(n) S
  public static int shortestPath(List<List<String>> edges, String nodeA, String nodeB) {
    Map<String, List<String>> graph = convertToGraph(edges);
    Set<String> visitedNodes = new HashSet<>();
    Queue<SimpleEntry<String, Integer>> queue = new ArrayDeque<>();
    queue.offer(new SimpleEntry<>(nodeA, 0));
    visitedNodes.add(nodeA);
    while (!queue.isEmpty()) {
      SimpleEntry<String, Integer> entry = queue.remove();
      String node = entry.getKey();
      int distance = entry.getValue();
      if (node.equals(nodeB)) {
        return distance;
      }
      for (String neighbor : graph.get(node)) {
        if (!visitedNodes.contains(neighbor)) {
          queue.offer(new SimpleEntry<>(neighbor, distance + 1));
          visitedNodes.add(neighbor);
        }
      }
    }
    return -1;
  }

  private static Map<String, List<String>> convertToGraph(List<List<String>> edges) {
    Map<String, List<String>> graph = new HashMap<>();
    for (List<String> edge : edges) {
      String a = edge.get(0);
      String b = edge.get(1);
      if (!graph.containsKey(a)) {
        graph.put(a, new ArrayList<>());
      }
      if (!graph.containsKey(b)) {
        graph.put(b, new ArrayList<>());
      }
      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    return graph;
  }

  public static void main(String[] args) {
    List<List<String>> edges =
        List.of(List.of("w", "x"), List.of("x", "y"), List.of("z", "y"), List.of("z", "v"),
                List.of("w", "v"));
    System.out.println(ShortestPath.convertToGraph(edges));
    System.out.println(ShortestPath.shortestPath(edges, "w", "z"));
  }
}
