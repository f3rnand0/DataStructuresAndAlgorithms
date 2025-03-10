package code.interview.linkedlist;

public class Traversal {

  // O (n) T
  // O (1) S
  public static String traverseUsingWhile(Node node) {
      String result = "";
      while (node != null) {
        result += node.val + " -> ";
        node = node.next;
      }
      result += "null";
      return result;
  }

  // O (n) T
  // O (n) S
  public static String traverseUsingRecursion(Node node) {
    String result = "";
    if (node == null)
      return "null";
    result += node.val + " -> " + traverseUsingRecursion(node.next);
    return result;
  }

  public static void main(String[] args){
    Node<String> nodeA = new Node<>("A");
    Node<String> nodeB = new Node<>("B");
    Node<String> nodeC = new Node<>("C");
    Node<String> nodeD = new Node<>("D");
    nodeA.next = nodeB;
    nodeB.next = nodeC;
    nodeC.next = nodeD;
    System.out.println(Traversal.traverseUsingWhile(nodeA));
    System.out.println(Traversal.traverseUsingRecursion(nodeA));
  }
}
