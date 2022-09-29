package code.interview.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupAnagrams {

    // Generate a list of sorted words by ordering every word's character alphabetically, where
    // its order will be the same as the 'words' array. Then, create an auxiliary array with indices
    // of the 'words' array ordered lexicographically by the words in 'sorted' array. Iterate over
    // the indices array to form anagram groups by getting the corresponding words that are anagrams
    // between them.
    // O((w * n * log(n)) + (n * w * log(w)) T
    // O(w * n) S, where w is the number of words and n is the length of the longest word
    public static List<List<String>> groupAnagramsByIndices(List<String> words) {
        if (words.size() == 0) {
            return new ArrayList<>();
        }

        List<String> sortedWords = new ArrayList<>();
        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            sortedWords.add(sortedWord);
        }

        List<Integer> indices =
            IntStream.range(0, words.size()).boxed().collect(Collectors.toList());
        indices.sort(Comparator.comparing(sortedWords::get));

        List<List<String>> result = new ArrayList<>();
        List<String> currentAnagramGroup = new ArrayList<>();
        String currentAnagram = sortedWords.get(indices.get(0));
        for (Integer index : indices) {
            String word = words.get(index);
            String sortedWord = sortedWords.get(index);

            if (sortedWord.equals(currentAnagram)) {
                currentAnagramGroup.add(word);
                continue;
            }

            result.add(currentAnagramGroup);
            currentAnagramGroup = new ArrayList<>(Arrays.asList(word));
            currentAnagram = sortedWord;
        }

        result.add(currentAnagramGroup);
        return result;
    }

    // Using the same reasoning to determine anagrams order every word's character alphabetically.
    // And at the same time group every anagram in a hash table that has the sorted word as key and
    // a list of the grouped anagrams as values
    // O(w * n * log(n)) T
    // O(w * n) S, where w is the number of words and n is the length of the longest word
    public static List<List<String>> groupAnagramsByWords(List<String> words) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (anagrams.containsKey(sortedWord)) {
                anagrams.get(sortedWord).add(word);
            } else {
                anagrams.put(sortedWord, new ArrayList<>(Arrays.asList(word)));
            }
        }

        return new ArrayList<>(anagrams.values());
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp");
        System.out.println(GroupAnagrams.groupAnagramsByIndices(list));
        System.out.println(GroupAnagrams.groupAnagramsByWords(list));
    }
}
