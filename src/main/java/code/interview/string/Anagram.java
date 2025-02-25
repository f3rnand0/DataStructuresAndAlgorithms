package code.interview.string;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

  // Count the occurrences of every character in both strings and compare them.
  // O (n + m) T
  // O (n + m) S
  public static boolean anagrams(String s1, String s2) {
    return charCount(s1).equals(charCount(s2));
  }

  private static Map<Character,Integer> charCount(String s){
    Map<Character, Integer> charCount = new HashMap<>();
    for (char c : s.toCharArray()) {
      if (!charCount.containsKey(c)) {
        charCount.put(c, 0);
      }
      charCount.put(c, charCount.get(c) + 1);
    }
    return charCount;
  }

  public static void main(String[] args){
    System.out.println(Anagram.anagrams("hello", "olleh"));
    System.out.println(Anagram.anagrams("hello", "olle"));
    System.out.println(Anagram.anagrams("olle", "olleh"));
    System.out.println(Anagram.anagrams("paper", "reapa"));
  }
}
