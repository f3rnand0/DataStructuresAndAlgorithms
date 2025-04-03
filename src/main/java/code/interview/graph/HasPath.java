package code.interview.graph;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class HasPath {

  // Traverse the graph in a depth manner. The base case is when the destination is equal to the
  // src (neighbor in the current iteration)
  // O(n^2) T, n is the number of nodes. It's n^2 because in the worst case it iterates through all
  // the edges
  // O(n) S
  public static boolean hasPathUsingDFT(Map<String, List<String>> graph, String src, String dst) {
    if (src.equals(dst)) {
      return true;
    }
    for (String neighbor : graph.get(src)) {
      if (hasPathUsingDFT(graph, neighbor, dst)) {
        return true;
      }
    }
    return false;
  }

  // Traverse the graph in a breadth manner. Use a queue to iterate every node. The neighbors must
  // be added to the queue before the next while iteration
  // O(n^2) T, n is the number of nodes. It's n^2 because in the worst case it iterates through all
  // the edges
  // O(n) S
  public static boolean hasPathUsingBFT(Map<String, List<String>> graph, String src, String dst) {
    Queue<String> queue = new ArrayDeque<>();
    queue.offer(src);
      while (!queue.isEmpty()) {
        String current = queue.remove();
        if (current.equals(dst)) {
          return true;
        }
        for (String neighbor : graph.get(current)) {
          queue.offer(neighbor);
        }
      }
    return false;
  }

  public static void main(String[] args) {
    Map<String, List<String>> graph = Map.of(
        "f", List.of("g", "i"),
        "g", List.of("h"),
        "h", List.of(),
        "i", List.of("g", "k"),
        "j", List.of("i"),
        "k", List.of()
    );
    System.out.println(hasPathUsingDFT(graph, "f", "k")); // true
    System.out.println(hasPathUsingBFT(graph, "f", "k")); // true
    graph = Map.of(
        "f", List.of("g", "i"),
        "g", List.of("h"),
        "h", List.of(),
        "i", List.of("g", "k"),
        "j", List.of("i"),
        "k", List.of()
    );
    System.out.println(hasPathUsingDFT(graph, "f", "j")); // false
    System.out.println(hasPathUsingBFT(graph, "f", "j")); // false
  }
}
