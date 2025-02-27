package code.interview.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class Values {

  // O(n) T
  // O(n) T
  public static List<String> linkedListValuesUsingWhile(Node<String> head) {
    List<String> values = new ArrayList<>();
    while (head != null) {
      values.add(head.val);
      head = head.next;
    }
    return values;
  }

  // Use another method to use the list through all the calls
  // O(n) T
  // O(n) T
  public static List<String> linkedListValuesUsingRecursion(Node<String> head) {
    List<String> values = new ArrayList<>();
    return fillValues(values, head);
  }

  private static List<String> fillValues(List<String> values, Node<String> head) {
    if (head == null) {
      return values;
    }
    values.add(head.val);
    return fillValues(values, head.next);
  }

  public static void main(String[] args){
    Node<String> a = new Node<>("a");
    Node<String> b = new Node<>("b");
    Node<String> c = new Node<>("c");
    Node<String> d = new Node<>("d");
    a.next = b;
    b.next = c;
    c.next = d;
    System.out.println(linkedListValuesUsingWhile(a));
    System.out.println(linkedListValuesUsingRecursion(a));
    Node<String> q = new Node<>("q");
    System.out.println(linkedListValuesUsingWhile(q));
    System.out.println(linkedListValuesUsingRecursion(q));
  }
}

class Node<T> {
  T val;
  Node<T> next;

  public Node(T val) {
    this.val = val;
    this.next = null;
  }
}