package code.interview.array;

import java.util.HashMap;
import java.util.List;

public class PairSum {


  // Use two loops to iterate through all the possible combinations
  // O (n^2) T
  // O (1) S
  public static List<Integer> pairSumUsingTwoLoops(List<Integer> numbers, int target) {
    for (int i = 0; i < numbers.size(); i++) {
      for (int j = i + 1; j < numbers.size(); j++) {
        if (numbers.get(i) + numbers.get(j) == target) {
          return List.of(i, j);
        }
      }
    }
    return null;
  }

  // Use a remainder to check versus other previous numbers stored in a Map. In every iteration
  // the remainder (target - current number) is used to check if exists on a Map tha has all
  // the previous iterated numbers. Once it's found a list it's returned with the indexes of
  // the pair-sum numbers
  // O (n) T
  // O (n) S
  public static List<Integer> pairSumUsingHashMap(List<Integer> numbers, int target) {
    HashMap<Integer,Integer> indexes = new HashMap<>();
    indexes.put(numbers.get(0), 0);
    // 1,0 -
    for (int i = 1; i < numbers.size(); i++) {
      int complement = target - numbers.get(i);
      if (indexes.containsKey(complement)) {
        return List.of(indexes.get(complement),i);
      }
      indexes.put(numbers.get(i), i);
    }
    return null;
  }

  public static void main(String[] args) {
    System.out.println(PairSum.pairSumUsingTwoLoops(List.of(3, 2, 5, 4, 1), 8));
    System.out.println(PairSum.pairSumUsingTwoLoops(List.of(1, 6, 7, 2), 13));
    System.out.println(PairSum.pairSumUsingHashMap(List.of(3, 2, 5, 4, 1), 8));
    System.out.println(PairSum.pairSumUsingHashMap(List.of(1, 6, 7, 2), 13));
  }
}
