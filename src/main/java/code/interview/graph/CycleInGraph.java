package code.interview.graph;

import java.util.Arrays;

public class CycleInGraph {

    // Graph edges types
    // - tree edge: an edge that discovers a vertex that is not already in the tree
    // - back edge: an edge that connects a descendant with an ancestor that has already been
    // visited. Helps to define a cycle inside a graph
    // - cross edge: an edge that connects two nodes of different subtrees
    // - forward edge: an edge that connects an ancestor with a descendant that has already been
    // visited

    public int WHITE = 0;
    public int GREY = 1;
    public int BLACK = 2;

    // Using depth first search on every node define every visited node and node that are
    // currently in the call stack. In this way back edges can be used to define if there's a
    // cycle or not.
    // The nodes present in the visited array and in the current stack array indicate the
    // ancestors for the current node. In that case a back edge has been found and there's a
    // cycle in the graph
    // O(v + e) T
    // O(v) S, where v are the number of vertices, and e the number of edges in the graph
    public boolean cycleInGraphUsingTwoDataStructures(int[][] edges) {
        int numberOfNodes = edges.length;
        boolean[] visited = new boolean[numberOfNodes];
        boolean[] currentlyInStack = new boolean[numberOfNodes];
        Arrays.fill(visited, false);
        Arrays.fill(currentlyInStack, false);

        for (int node = 0; node < numberOfNodes; node++) {
            if (visited[node]) {
                continue;
            }
            boolean containsCycle = isNodeInCycle(node, edges, visited, currentlyInStack);
            if (containsCycle) {
                return true;
            }
        }
        return false;
    }

    public boolean isNodeInCycle(int node, int[][] edges, boolean[] visited,
        boolean[] currentlyInStack) {
        visited[node] = true;
        currentlyInStack[node] = true;

        boolean containsCycle = false;
        int[] neighbors = edges[node];
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                containsCycle = isNodeInCycle(neighbor, edges, visited, currentlyInStack);
            }
            if (containsCycle) {
                return true;
            } else if (currentlyInStack[neighbor]) {
                return true;
            }
        }

        currentlyInStack[node] = false;
        return false;
    }

    // Using depth first search on every node define every visited node and node that are
    // currently in the call stack. In this way back edges can be used to define if there's a
    // cycle or not.
    // If the node visited is WHITE it means it's unvisited, if it's GREY it means it's in the
    // stack and therefore a back edged and a cycle is present, and if it's BLACK the path has
    // been finished, so it could be discarded
    // O(v + e) T
    // O(v) S, where v are the number of vertices, and e the number of edges in the graph
    public boolean cycleInGraphUsingThreeColors(int[][] edges) {
        int numberOfNodes = edges.length;
        int[] colors = new int[numberOfNodes];
        Arrays.fill(colors, WHITE);

        for (int node = 0; node < numberOfNodes; node++) {
            if (colors[node] != WHITE) {
                continue;
            }

            boolean containsCycle = traverseAndColorNodes(node, edges, colors);
            if (containsCycle) {
                return true;
            }
        }

        return false;
    }

    private boolean traverseAndColorNodes(int node, int[][] edges, int[] colors) {
        colors[node] = GREY;

        int[] neighbors = edges[node];
        for (int neighbor : neighbors) {
            int neighborColor = colors[neighbor];

            if (neighborColor == GREY) {
                return true;
            }

            if (neighborColor == BLACK) {
                continue;
            }

            boolean containsCycle = traverseAndColorNodes(neighbor, edges, colors);
            if (containsCycle) {
                return true;
            }
        }
        colors[node] = BLACK;
        return false;
    }
}
