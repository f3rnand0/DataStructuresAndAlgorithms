package code.interview.array;

public class PrimeNumber {

  // O(n) T
  // O(1) S
  public static boolean isPrimeUsingAllNumbers(int number) {
    if (number < 2) {
      return false;
    }
    for(int i = 2; i < number; i++) {
      if (number % i == 0)
        return false;
    }
    return true;
  }

  // O(sqrt(n)) T
  // O(1) S
  public static boolean isPrime(int number) {
    if (number < 2) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(number); i += 1) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(PrimeNumber.isPrimeUsingAllNumbers(0));
    System.out.println(PrimeNumber.isPrimeUsingAllNumbers(1));
    System.out.println(PrimeNumber.isPrimeUsingAllNumbers(64));
    System.out.println(PrimeNumber.isPrimeUsingAllNumbers(19));
    System.out.println(PrimeNumber.isPrime(0));
    System.out.println(PrimeNumber.isPrime(1));
    System.out.println(PrimeNumber.isPrime(64));
    System.out.println(PrimeNumber.isPrime(19));
  }
}
