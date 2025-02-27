package code.interview.linkedlist;

public class Traversal {

  // O (n) T
  // O (1) S
  public static String traverseUsingWhile(Node node) {
      String result = "";
      while (node != null) {
        result += node.value + " -> ";
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
    result += node.value + " -> " + traverseUsingRecursion(node.next);
    return result;
  }

  public static void main(String[] args){
    Node nodeA = new Node("A");
    Node nodeB = new Node("B");
    Node nodeC = new Node("C");
    Node nodeD = new Node("D");
    nodeA.next = nodeB;
    nodeB.next = nodeC;
    nodeC.next = nodeD;
    System.out.println(Traversal.traverseUsingWhile(nodeA));
    System.out.println(Traversal.traverseUsingRecursion(nodeA));
  }

  static class Node {
    private String value;
    private Node next;
    Node(String value) {
      this.value = value;
      this.next = null;
    }
  }
}
