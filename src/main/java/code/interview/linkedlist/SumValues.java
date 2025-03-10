package code.interview.linkedlist;

public class SumValues {

  // O(n) T
  // O(1) S
  public static int sumListUsingWhile(Node<Integer> head) {
    int sum = 0;
    Node<Integer> current = head;
    while (current != null) {
      sum += current.val;
      current = current.next;
    }
    return sum;
  }

  // O(n) T
  // O(n) S
  public static int sumListUsingRecursion(Node<Integer> head) {
    if (head == null) {
      return 0;
    }
    return head.val + sumListUsingRecursion(head.next);
  }

  public static void main(String[] args){
    Node<Integer> a = new Node<>(2);
    Node<Integer> b = new Node<>(8);
    Node<Integer> c = new Node<>(3);
    Node<Integer> d = new Node<>(-1);
    Node<Integer> e = new Node<>(7);
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;
    System.out.println(SumValues.sumListUsingWhile(a));
    System.out.println(SumValues.sumListUsingRecursion(a));
    System.out.println(SumValues.sumListUsingWhile(null));
    System.out.println(SumValues.sumListUsingRecursion(null));
  }
}
