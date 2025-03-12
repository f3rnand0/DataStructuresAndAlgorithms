package code.interview.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstValues {

  // Use a stack to store values of the tree. Start with the root, and then the children.
  // First the left and the right children. Then with their the children, again first the left
  // and then the right children respectively.
  // O(n) T
  // O(n) S
  public static List<String> breadthFirstValues(Node<String> root) {
    List<String> values = new ArrayList<>();
    if (root == null) {
      return values;
    }
    Queue<Node<String>> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node<String> node = queue.remove();
      values.add(node.val);
      if (node.left != null) {
        queue.add(node.left);
      }
      if (node.right != null) {
        queue.add(node.right);
      }
    }
    return values;
  }

  public static void main(String[] args) {
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
    System.out.println(BreadthFirstValues.breadthFirstValues(a));
    System.out.println(BreadthFirstValues.breadthFirstValues(null));
  }
}
