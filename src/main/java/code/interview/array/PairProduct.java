package code.interview.array;

import java.util.HashMap;
import java.util.List;

public class PairProduct {

  // Use a complement to check versus other previous numbers stored in a Map. In every iteration
  // the complement (target / current number) is used to check if exists on a Map tha has all
  // the previous iterated numbers. Once it's found a list it's returned with the indexes of
  // the pair-product numbers
  // O (n) T
  // O (n) S
  public static List<Integer> pairProductUsingHashMap(List<Integer> numbers, int target) {
    HashMap<Double,Integer> indexes = new HashMap<>();
    indexes.put(Double.valueOf(numbers.get(0)), 0);
    for (int i = 1; i < numbers.size(); i++) {
      double complement = target / numbers.get(i);
      if (indexes.containsKey(complement)) {
        return List.of(indexes.get(complement),i);
      }
      indexes.put(Double.valueOf(numbers.get(i)), i);
    }
    return null;
  }

  public static void main(String[] args) {
    System.out.println(PairProduct.pairProductUsingHashMap(List.of(3, 2, 5, 4, 1), 8));
    System.out.println(PairProduct.pairProductUsingHashMap(List.of(4, 7, 9, 2, 5, 1), 35));
  }
}
