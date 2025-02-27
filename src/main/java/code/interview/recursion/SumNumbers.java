package code.interview.recursion;

import java.util.List;

public class SumNumbers {

  // The base case is the sum of an empty list is 0. Then, the recursive step consists of
  // adding the first element of the list with the remaining integers as a sublist
  // O(n^2) T
  // O(n^2) S
  public static int sumNumbersRecursive(List<Integer> numbers) {
    if (numbers.isEmpty()) {
      return 0;
    }
    return numbers.get(0) + sumNumbersRecursive(numbers.subList(1, numbers.size()));
  }

  public static void main(String[] args){
    System.out.println(SumNumbers.sumNumbersRecursive(List.of(5, 2, 9, 10)));
    System.out.println(SumNumbers.sumNumbersRecursive(List.of(1000, 0, 0, 0, 0, 0, 1)));
  }
}
