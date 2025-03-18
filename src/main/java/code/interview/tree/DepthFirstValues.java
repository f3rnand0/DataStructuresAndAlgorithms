package code.interview.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstValues {

  // Use a stack to store values of the tree. Start with the root, and then the children.
  // First the left and its children subsequently (first the left, then the right), then
  // the right and its children subsequently (first the left, then the right).
  // Always insert the right child before the left child. It ends when the stack is empty
  // O(n) T
  // O(n) S
  public static List<String> depthFirstValuesUsingWhile(Node<String> root) {
    List<String> values = new ArrayList<>();
    Stack<Node<String>> stack = new Stack<>();
    if (root != null) {
      stack.push(root);
    }
    while (!stack.isEmpty()) {
      Node<String> current = stack.pop();
      values.add(current.val);
      if (current.right != null) {
        stack.push(current.right);
      }
      if (current.left != null) {
        stack.push(current.left);
      }
    }
    return values;
  }

  // Use the recursion stack call to traverse the tree. Start with the root, and then the children.
  // O(n) T
  // O(n) S
  public static List<String> depthFirstValuesUsingRecursion(Node<String> root) {
    if (root == null) {
      return List.of();
    }
    List<String> values = new ArrayList<>();
    values.add(root.val);
    values.addAll(depthFirstValuesUsingRecursion(root.left));
    values.addAll(depthFirstValuesUsingRecursion(root.right));
    return values;
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
    System.out.println(depthFirstValuesUsingWhile(a));
    System.out.println(depthFirstValuesUsingWhile(null));
    System.out.println(depthFirstValuesUsingRecursion(a));
    System.out.println(depthFirstValuesUsingRecursion(null));
  }
}
