package code.interview.linkedlist;

public class Find {

  // O(n) T
  // O(1) S
  public static <T> boolean linkedListFindUsingWhile(Node<T> head, T target) {
    Node<T> current = head;
    while (current != null) {
      if (current.val == target) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  // O(n) T
  // O(n) S
  public static <T> boolean linkedListFindUsingRecursion(Node<T> head, T target) {
    if (head == null) {
      return false;
    }
    if (head.val == target) {
      return true;
    }
    return linkedListFindUsingRecursion(head.next, target);
  }

  public static void main(String[] args){
    Node<String> a = new Node<>("a");
    Node<String> b = new Node<>("b");
    Node<String> c = new Node<>("c");
    Node<String> d = new Node<>("d");
    a.next = b;
    b.next = c;
    c.next = d;
    System.out.println(Find.linkedListFindUsingWhile(a, "d"));
    System.out.println(Find.linkedListFindUsingRecursion(a, "d"));
    Node<Integer> node1 = new Node<>(42);
    System.out.println(Find.linkedListFindUsingWhile(node1, 100));
    System.out.println(Find.linkedListFindUsingRecursion(node1, 100));
  }
}
