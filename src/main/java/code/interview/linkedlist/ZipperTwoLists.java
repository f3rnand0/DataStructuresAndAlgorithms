package code.interview.linkedlist;

public class ZipperTwoLists {

  // Use two pointers for every list and advance them on every iteration. A pointer to the tail
  // is needed to advance in the new zipper list.
  // A counter is used to define which list must be moved on. If the counter is odd advance only
  // the first list, if it's even advance only the second list.
  // Also when one of the lists is finished, just attach the remaining of the bigger list to the
  // tail
  // O(min(n,m)) T
  // O(1) S
  public static <T> Node<T> zipperListsUsingWhile(Node<T> head1, Node<T> head2) {
    Node<T> current1 = head1.next;
    Node<T> current2 = head2;
    Node<T> tail = head1;
    int counter = 1;
    while (current1 != null && current2 != null) {
      if (counter % 2 == 0) {
        tail.next = current1;
        current2 = current2.next;
      } else {
        tail.next = current2;
        current1 = current1.next;
      }
      tail = tail.next;
      counter++;
    }
    if (current1 != null) {
      tail.next = current2;
    }
    if (current2 == null) {
      tail.next = current1;
    }
    return head1;
  }

  // The base case is when either of the lists is null. In that case return the remaining
  // bigger list.
  // A counter is used to define which list must be moved on. If the counter is odd make a
  // recursive call with the next of the first list and the current of the second list, and return
  // the current of the first list
  // If it's even make a recursive call with the current of the first list and the next of the
  // second list, and return the current of the second list
  // O(min(n,m))
  // O(min(n,m))
  public static <T> Node<T> zipperListsUsingRecursion(Node<T> head1, Node<T> head2) {
    return zipperLists(head1, head2, 0);
  }

  private static <T> Node<T> zipperLists(Node<T> head1, Node<T> head2, int count) {
    if (head1 == null) {
      return head2;
    }
    if (head2 == null) {
      return head1;
    }

    if (count % 2 == 0) {
      head1.next = zipperLists(head1.next, head2, count + 1);
      return head1;
    } else {
      head2.next = zipperLists(head1, head2.next, count + 1);
      return head2;
    }
  }

  public static void main(String[] args){
    Node<String> a = new Node<>("a");
    Node<String> b = new Node<>("b");
    Node<String> c = new Node<>("c");
    a.next = b;
    b.next = c;
    Node<String> x = new Node<>("x");
    Node<String> y = new Node<>("y");
    Node<String> z = new Node<>("z");
    x.next = y;
    y.next = z;
    System.out.println(Traversal.traverseUsingWhile(ZipperTwoLists.zipperListsUsingWhile(a, x)));
  }
}
