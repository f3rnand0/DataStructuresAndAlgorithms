package code.interview.tree;

public class MaxRootToLeafSum {

  // Use recursion to iterate the tree in a DFS manner. To get the max sum choose between the
  // nodes (left and right) whose value is the biggest. Then it can be summed it with the current
  // node value. Also, for a null node return with negative infinity. So the max comparison works
  // properly.
  // O(n) T
  // O(n) S
  public static Double maxPathSum(Node<Double> root) {
    if (root == null) {
      return Double.NEGATIVE_INFINITY;
    }
    if (root.left == null && root.right == null) {
      return root.val;
    }
    double maxLeft = maxPathSum(root.left);
    double maxRight = maxPathSum(root.right);
    return root.val + Math.max(maxLeft, maxRight);
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
    System.out.println(maxPathSum(a));

    a = new Node<>(42.);
    //        42
    System.out.println(maxPathSum(a));
  }
}
