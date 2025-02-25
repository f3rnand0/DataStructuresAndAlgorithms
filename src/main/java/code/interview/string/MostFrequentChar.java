package code.interview.string;

import java.util.HashMap;

public class MostFrequentChar {

  // Count the occurrences of every character. Then, iterate through the string to find
  // the most frequent and recent character.
  // O(n) T
  // O(n) S
  public static char mostFrequentChar(String s) {
    HashMap<Character, Integer> occurrences = charCount(s);
    char mostFrequent = s.charAt(0);
    for(int i = 1; i < s.length(); i++) {
      if (occurrences.get(mostFrequent) < occurrences.get(s.charAt(i))) {
        mostFrequent = s.charAt(i);
      }
    }
    return mostFrequent;
  }

  public static HashMap<Character, Integer> charCount(String s) {
    HashMap<Character, Integer> charCount = new HashMap<>();
    for (char c : s.toCharArray()) {
      if (!charCount.containsKey(c)) {
        charCount.put(c, 0);
      }
      charCount.put(c, charCount.get(c) + 1);
    }
    return charCount;
  }

  public static void main(String[] args){
    System.out.println(MostFrequentChar.mostFrequentChar("pota"));
    System.out.println(MostFrequentChar.mostFrequentChar("potato"));
  }
}
