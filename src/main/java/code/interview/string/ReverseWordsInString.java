package code.interview.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInString {

    // Find every word by searching the first character that is not a space. Once a word is found
    // add it to the list and advance the startOfWord index to the current value of idx. Then, when
    // a space is found add it to eh list too. Then, the for loop will advance on the characters of
    // the next word once a new space si found, this will be performed with every word. Finally,
    // reverse the list and use String.join to create the resulting string
    // O(n) T
    // O(n) S
    public String reverseWordsInStringUsingList(String string) {
        List<String> words = new ArrayList<>();
        int startOfWord = 0;
        for (int idx = 0; idx < string.length(); idx++) {
            char character = string.charAt(idx);

            if (character == ' ') {
                words.add(string.substring(startOfWord, idx));
                startOfWord = idx;
            } else if (string.charAt(startOfWord) == ' ') {
                words.add(" ");
                startOfWord = idx;
            }
        }

        words.add(string.substring(startOfWord));

        Collections.reverse(words);
        return String.join("", words);
    }

    // First the reverse the entire string. Then, iterate over this new string to reverse only the
    // reversed words. So, find every word and reverse it using the same method that reversed the
    // entire string. As the previous solution, the same principle is used to find every word, by
    // finding the first space after a word
    // O(n) T
    // O(n) S
    public String reverseWordsInStringByReversingEverything(String string) {
        char[] characters = string.toCharArray();
        reverseListRange(characters, 0, characters.length - 1);

        int startOfWord = 0;
        while (startOfWord < characters.length) {
            int endOfWord = startOfWord;
            while (endOfWord < characters.length && characters[endOfWord] != ' ') {
                endOfWord += 1;
            }

            reverseListRange(characters, startOfWord, endOfWord - 1);
            startOfWord = endOfWord + 1;
        }

        return new String(characters);
    }

    public char[] reverseListRange(char[] list, int start, int end) {
        while (start < end) {
            char temp = list[start];
            list[start] = list[end];
            list[end] = temp;
            start += 1;
            end -= 1;
        }

        return list;
    }

    public static void main(String[] args) {
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        System.out.println(
            reverseWordsInString.reverseWordsInStringUsingList("AlgoExpert is the best!"));
        System.out.println(reverseWordsInString.reverseWordsInStringUsingList(
            "this      string     has a     lot of   whitespace"));
    }
}
