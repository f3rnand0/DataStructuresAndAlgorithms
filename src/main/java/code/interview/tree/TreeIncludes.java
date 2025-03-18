package code.interview.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeIncludes {

  // Use a queue to iterate using BFS. By using a queue to store the left and right child
  // of the current node. Return true if the value of the current node matches the target
  // O(n) T
  // O(n) S
  public static boolean treeIncludesUsingBFS(Node<String> root, String target) {
    Queue<Node<String>> queue = new ArrayDeque<>();
    if (root != null) {
      queue.offer(root);
    }
    while (!queue.isEmpty()) {
      Node<String> current = queue.poll();
      if (current.val.equals(target)) {
        return true;
      }
      if (current.left != null) {
        queue.offer(current.left);
      }
      if (current.right != null) {
        queue.offer(current.right);
      }
    }
    return false;
  }

  // Use recursion to iterate the tree using DFS. Using the recursion stack go deeper to the
  // left children first, and then to the right children. Use logical OR to define if the
  // target value matches or not. So, it could: true || false, false || true, or false || false
  // O(n) T
  // O(n) S
  public static boolean treeIncludesUsingDFS(Node<String> root, String target) {
    if (root == null) {
      return false;
    }
    if (root.val.equals(target)) {
      return true;
    }
    return treeIncludesUsingDFS(root.left, target) || treeIncludesUsingDFS(root.right, target);
  }

  public static void main(String[] args){
    Node<String> a = new Node<>("a");
    Node<String> b = new Node<>("b");
    Node<String> c = new Node<>("c");
    Node<String> d = new Node<>("d");
    Node<String> e = new Node<>("e");
    Node<String> f = new Node<>("f");
    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.right = f;
    //      a
    //    /   \
    //   b     c
    //  / \     \
    // d   e     f

    System.out.println(treeIncludesUsingBFS(a, "e"));
    System.out.println(treeIncludesUsingBFS(null, "e"));
    System.out.println(treeIncludesUsingDFS(a,"e"));
    System.out.println(treeIncludesUsingDFS(null, "e"));
  }
}
