package code.interview.tree;

import java.util.Stack;

public class TreeSum {

  // Do a depth first traversal to sum all the values. Use the stack call of the
  // recursive calls. The formula is simple. Just sum the total value of the left child
  // plus the current value, and plus the total value of the right child
  // O(n) T
  // O(n) S
  public static int treeSumUsingRecursion(Node<Integer> root) {
    if (root == null) {
      return 0;
    }
    return treeSumUsingRecursion(root.left) + root.val + treeSumUsingRecursion(root.right);
  }

  // Use a stack to do a depth first traversal. Sum the value of every iterated node.
  // The null check isn't needed because the stack will contain only non-null values.
  // O(n) T
  // O(n) S
  public static int treeSumUsingWhile(Node<Integer> root) {
    Stack<Node<Integer>> stack = new Stack<>();
    int sum = 0;
    Node<Integer> current = root;
    if (current != null) {
      stack.push(current);
    }
    while(!stack.isEmpty()) {
      current = stack.pop();
      sum += current.val;
      if (current.left != null) {
        stack.push(current.left);
      }
      if (current.right != null) {
        stack.push(current.right);
      }
    }
    return sum;
  }


  public static void main(String[] args){
    Node<Integer> a = new Node<>(3);
    Node<Integer> b = new Node<>(11);
    Node<Integer> c = new Node<>(4);
    Node<Integer> d = new Node<>(4);
    Node<Integer> e = new Node<>(-2);
    Node<Integer> f = new Node<>(1);
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

    System.out.println(treeSumUsingRecursion(a));
    System.out.println(treeSumUsingRecursion(null));
    System.out.println(treeSumUsingWhile(a));
    System.out.println(treeSumUsingWhile(null));
  }
}
