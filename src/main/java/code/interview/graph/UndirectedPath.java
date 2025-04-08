package code.interview.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class UndirectedPath {

  // First, convert the list of edges to an adjacency list. Then use BFT to traverse the graph
  // and also use a Set to store the visited nodes. It's needed because there could be cycles
  // that will make the method run endlessly. So, a check is needed once getting after getting
  // every neighbor of the current node. Also, the node is added to the visitedNodes Set once it
  // was added to the queue
  // O(e) T
  // O(n) S
  public static boolean undirectedPathUsingBFT(List<List<String>> edges, String nodeA,
                                               String nodeB) {
    Map<String, List<String>> graph = buildGraph(edges);
    // System.out.println(graph);
    Set<String> visitedNodes = new HashSet<>();
    Queue<String> queue = new ArrayDeque<>();
    queue.offer(nodeA);
    visitedNodes.add(nodeA);
    while (!queue.isEmpty()) {
      String current = queue.remove();
      if (current.equals(nodeB)) {
        return true;
      }
      for (String neighbor : graph.get(current)) {
        if (!visitedNodes.contains(current)) {
          queue.offer(neighbor);
          visitedNodes.add(current);
        }
      }
    }
    return false;
  }

  // First, convert the list of edges to an adjacency list. Then use DFT to traverse the graph
  // and also use a Set to store the visited nodes. It's needed because there could be cycles
  // that will make the recursion run endlessly. So, it's represented as another base case for
  // the recursion. Also, the nodeA is added to the visitedNodes Set after the base cases
  // O(e) T
  // O(n) S
  public static boolean undirectedPathUsingDFT(List<List<String>> edges, String nodeA,
                                               String nodeB) {
    Map<String, List<String>> graph = buildGraph(edges);
    Set<String> visitedNodes = new HashSet<>();
    return UndirectedPath.undirectedPathUsingDFT(graph, visitedNodes, nodeA, nodeB);
  }

  private static boolean undirectedPathUsingDFT(Map<String, List<String>> graph,
                                                Set<String> visitedNodes, String nodeA,
                                                String nodeB) {
    if (nodeA.equals(nodeB)) {
      return true;
    }
    if (visitedNodes.contains(nodeA)) {
      return false;
    }
    visitedNodes.add(nodeA);
    for (String neighbor : graph.get(nodeA)) {
      if (undirectedPathUsingDFT(graph, visitedNodes, neighbor, nodeB)) {
        return true;
      }
    }
    return false;
  }

  private static Map<String, List<String>> buildGraph(List<List<String>> edges) {
    Map<String, List<String>> graph = new HashMap<>();
    for (List<String> edge : edges) {
      String a = edge.getFirst();
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
        List.of(List.of("i", "j"), List.of("k", "i"), List.of("m", "k"), List.of("k", "l"),
                List.of("o", "n"));
    System.out.println(UndirectedPath.undirectedPathUsingBFT(edges, "j", "m"));
    System.out.println(UndirectedPath.undirectedPathUsingDFT(edges, "j", "m"));
    edges = List.of(List.of("b", "a"), List.of("c", "a"), List.of("b", "c"), List.of("q", "r"),
                    List.of("q", "s"), List.of("q", "u"), List.of("q", "t"));
    System.out.println(UndirectedPath.undirectedPathUsingBFT(edges, "a", "b"));
    System.out.println(UndirectedPath.undirectedPathUsingDFT(edges, "a", "b"));
  }
}
