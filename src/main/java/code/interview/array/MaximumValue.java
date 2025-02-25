package code.interview.array;

public class MaximumValue {

  // O () T
  // O () S
  public static Integer maxValue(int[] nums) {
    var max = Integer.MIN_VALUE;
    for (int num : nums) {
      if (num > max) {
        max = num;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(MaximumValue.maxValue(new int[] {1, 2, 3, 4, 5}));
    System.out.println(MaximumValue.maxValue(new int[] {-1, -5, -2}));
  }
}