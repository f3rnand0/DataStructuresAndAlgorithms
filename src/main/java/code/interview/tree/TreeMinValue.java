package code.interview.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TreeMinValue {

  // Use a stack to iterate the values on DFS manner. Use double the positive infinity
  // value to check the minimum value with the values of the tree
  // O(n) T
  // O(n) S
  public static Double treeMinValueUsingDFSWhile(Node<Double> root) {
    Stack<Node<Double>> stack = new Stack<>();
    double min = Double.POSITIVE_INFINITY;
    if (root != null) {
      stack.push(root);
    }
    while (!stack.isEmpty()) {
      Node<Double> current = stack.pop();
      if (current.val < min) {
        min = current.val;
      }
      if (current.right != null) {
        stack.push(current.right);
      }
      if (current.left != null) {
        stack.push(current.left);
      }
    }
    return min;
  }

  // Use the recursion stack to iterate the values on DFS manner. Use the double positive
  // infinity value to check the minimum value with the values of the tree
  // O(n) T
  // O(n) S
  public static Double treeMinValueUsingDFSRecursion(Node<Double> root) {
    if (root == null) {
      return Double.POSITIVE_INFINITY;
    }
    double min = Math.min(treeMinValueUsingDFSRecursion(root.left), treeMinValueUsingDFSRecursion(root.right));
    return Math.min(root.val, min);
  }

  // Use a queue to iterate the values on BFS manner. Use double the positive infinity
  // value to check the minimum value with the values of the tree
  // O(n) T
  // O(n) S
  public static Double treeMinValueUsingBFS(Node<Double> root) {
    Queue<Node<Double>> queue = new ArrayDeque<>();
    if (root != null) {
      queue.offer(root);
    }
    double min = Double.POSITIVE_INFINITY;
    while (!queue.isEmpty()) {
      Node<Double> current = queue.poll();
      if (current.val < min) {
        min = current.val;
      }
      if (current.left != null) {
        queue.offer(current.left);
      }
      if (current.right != null) {
        queue.offer(current.right);
      }
    }
    return min;
  }

  public static void main(String[] args) {
    Node<Double> a = new Node<>(3.);
    Node<Double> b = new Node<>(11.);
    Node<Double> c = new Node<>(4.);
    Node<Double> d = new Node<>(4.);
    Node<Double> e = new Node<>(-2.);
    Node<Double> f = new Node<>(1.);
    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.right = f;
    //       3
    //    /    \
    //   11     4
    //  / \      \
    // 4   -2     1
    System.out.println(treeMinValueUsingDFSWhile(a));
    System.out.println(treeMinValueUsingDFSWhile(null));
    System.out.println(treeMinValueUsingDFSRecursion(a));
    System.out.println(treeMinValueUsingDFSRecursion(null));
    System.out.println(treeMinValueUsingBFS(a));
    System.out.println(treeMinValueUsingBFS(null));
  }
}
