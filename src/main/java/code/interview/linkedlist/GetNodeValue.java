package code.interview.linkedlist;

public class GetNodeValue {

  // Check in every iteration if the index is equal to a counter. If it's then return the value
  // If no value is encountered return null
  // O(n) T
  // O(1) S
  public static <T> T getNodeValueUsingWhile(Node<T> head, int index) {
    Node<T> current = head;
    int counter = 0;
    while (current != null) {
      if (counter == index) {
        return current.val;
      }
      current = current.next;
      counter++;
    }
    return null;
  }

  // Decrease the index and when it's 0 it will be the requested value. If the index never gets to
  // 0 null is returned
  // O(n) T
  // O(n) S
  public static <T> T getNodeValueUsingRecursion(Node<T> head, int index) {
    if (head == null) {
      return null;
    }
    if (index == 0) {
      return head.val;
    }
    return getNodeValueUsingRecursion(head.next, index - 1);
  }

  public static void main(String[] args){
    Node<String> a = new Node<>("a");
    Node<String> b = new Node<>("b");
    Node<String> c = new Node<>("c");
    Node<String> d = new Node<>("d");
    a.next = b;
    b.next = c;
    c.next = d;
    System.out.println(GetNodeValue.getNodeValueUsingWhile(a, 2));
    System.out.println(GetNodeValue.getNodeValueUsingWhile(a, 7));
    System.out.println(GetNodeValue.getNodeValueUsingRecursion(a, 2));
    System.out.println(GetNodeValue.getNodeValueUsingRecursion(a, 7));
  }
}
