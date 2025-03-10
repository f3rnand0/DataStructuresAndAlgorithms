package code.interview.tree;

public class Node<T> {
  T val;
  Node<T> left;
  Node<T> right;

  public Node(T val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}
