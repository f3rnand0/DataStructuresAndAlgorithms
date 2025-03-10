package code.interview.linkedlist;

public class Reverse {

  // Use two pointers while iterating the linked list. One that points to the previous node
  // , and other that points to the current node. Don't forget to save a reference to the
  // next node of the current node in the iteration. Stop iterating when the current node
  // is null
  // O(n) T
  // O(1) S
  public static <T> Node<T> reverseListUsingWhile(Node<T> head) {
    Node<T> previous = null;
    Node<T> current = head;
    while (current != null) {
      Node<T> next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    return previous;
  }

  // It uses the same algorithm. but it must save the value of previous. So, another function
  // is needed to do the recursion
  // O(n) T
  // O(n) S
  public static <T> Node<T> reverseListUsingRecursion(Node<T> head) {
    return reverseList(head, null);
  }

  private static <T> Node<T> reverseList(Node<T> current, Node<T> previous) {
    if (current == null) {
      return previous;
    }
    Node<T> next = current.next;
    current.next = previous;
    return reverseList(next, current);
  }

  public static void main(String[] args){
    Node<String> a = new Node<>("a");
    Node<String> b = new Node<>("b");
    Node<String> c = new Node<>("c");
    Node<String> d = new Node<>("d");
    a.next = b;
    b.next = c;
    c.next = d;
    System.out.println(Reverse.reverseListUsingWhile(a).val); // answer: d
    System.out.println(Reverse.reverseListUsingRecursion(a).val); // answer: a
  }

}
