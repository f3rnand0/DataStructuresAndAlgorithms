package code.interview.string;

import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

  // Generate substring using two indexes, one at the start that iterates through all the characters,
  // and other that advances until a repetition is found.
  // Used an insertion-ordered Set to check if the current character is repeated order. Once a
  // repetition is found the substring is generated and compared with the current longest substring.
  // That way is length of the longest substring is defined
  // O(n^3) T
  // O(n) S
  public int lengthOfLongestSubstring(String s) {
    if (s.isEmpty()) {
      return 0;
    }
    int j;
    Set<Character> currentStr = new LinkedHashSet<>();
    int longestSubstr = 0;
    for(int i=0; i<s.length(); i++) {
      j=i+1;
      currentStr.add(s.charAt(i));
      while (j < s.length() && !currentStr.contains(s.charAt(j))) {
        currentStr.add(s.charAt(j));
        j++;
      }
      if (longestSubstr < currentStr.size()) {
        longestSubstr = currentStr.size();
      }
      currentStr.clear();
    }
    return longestSubstr;
  }

  public static void main(String[] args) {
    LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
    System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcabc"));
    System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbbbb"));
    System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"));
    System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("_par_"));
  }
}
