package code.interview.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoArraysIntersection {

  // Use two loops to compare all numbers and put those that are equal in a List
  // O (n * m) T
  // O (n * m) S
  public static List<Integer> intersectionUsingTwoLoops(List<Integer> listA, List<Integer> listB) {
    List<Integer> intersection = new ArrayList<>();
    for (int i = 0; i < listA.size(); i++) {
      for (int j = 0; j < listB.size(); j++) {
        if (listA.get(i) == listB.get(j)) {
          intersection.add(listA.get(i));
        }
      }
    }
    return intersection;
  }

  public static List<Integer> intersectionUsingSet(List<Integer> listA, List<Integer> listB) {
    List<Integer> intersection = new ArrayList<>();
    Set<Integer> setA = new HashSet<>(listA);
    for (int i = 0; i < listB.size(); i++) {
      if (setA.contains(listB.get(i))) {
        intersection.add(listB.get(i));
      }
    }
    return intersection;
  }

  public static void main(String[] args) {
    List<Integer> a = List.of(4, 2, 1, 6);
    List<Integer> b = List.of(3, 6, 9, 2, 10);
    System.out.println(TwoArraysIntersection.intersectionUsingTwoLoops(a, b));
    System.out.println(TwoArraysIntersection.intersectionUsingSet(a, b));
    List<Integer> c = List.of(4, 2, 1);
    List<Integer> d = List.of(1, 2, 4, 6);
    System.out.println(TwoArraysIntersection.intersectionUsingTwoLoops(c, d));
    System.out.println(TwoArraysIntersection.intersectionUsingSet(c, d));
  }
}
