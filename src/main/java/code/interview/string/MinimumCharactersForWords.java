package code.interview.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumCharactersForWords {

    // The approach is to determine not only all the unique characters, but also their required
    // frequencies because there are scenarios where some characters are repeated and also the same
    // characters appear more times than in other words
    // First, by iterating on every word, define the frequencies of every character and store them
    // in a map. Then, define the current maximum frequencies of the characters that have appeared
    // by storing those values in another map. by comparing both maps the maximum frequencies can be
    // defined. Finally, transform the map of maximum frequencies to a char array as it's needed by
    // the method 'minimumCharactersForWords'
    // O(n * l) T, where n is the number of words and l is the length of the longest word
    // O(c) S, where c is the number of unique characters across all words. It's a lower bound when
    // there are repeated characters in at least one of the words
    // O(n * l) S, as upper bound when every character in unique across all words
    public char[] minimumCharactersForWords(String[] words) {
        HashMap<Character, Integer> maximumCharacterFrequencies = new HashMap<>();

        for (String word : words) {
            HashMap<Character, Integer> characterFrequencies = countCharacterFrequencies(word);
            updateMaximumFrequencies(characterFrequencies, maximumCharacterFrequencies);
        }

        return makeArrayFromCharacterFrequencies(maximumCharacterFrequencies);
    }

    private HashMap<Character, Integer> countCharacterFrequencies(String word) {
        HashMap<Character, Integer> characterFrequencies = new HashMap<>();

        for (char character : word.toCharArray()) {
            characterFrequencies.put(character,
                characterFrequencies.getOrDefault(character, 0) + 1);
        }

        return characterFrequencies;
    }

    private void updateMaximumFrequencies(HashMap<Character, Integer> characterFrequencies,
        HashMap<Character, Integer> maximumFrequencies) {

        for (var frequency : characterFrequencies.entrySet()) {
            char character = frequency.getKey();
            int characterFrequency = frequency.getValue();

            if (maximumFrequencies.containsKey(character)) {
                maximumFrequencies.put(character, Math.max(characterFrequency,
                    maximumFrequencies.get(character)));
            } else {
                maximumFrequencies.put(character, characterFrequency);
            }
        }
    }

    private char[] makeArrayFromCharacterFrequencies(
        HashMap<Character, Integer> characterFrequencies) {
        List<Character> characters = new ArrayList<Character>();

        for (var frequency : characterFrequencies.entrySet()) {
            char character = frequency.getKey();
            int characterFrequency = frequency.getValue();

            for (int i = 0; i < characterFrequency; i++) {
                characters.add(character);
            }
        }

        char[] charactersArray = new char[characters.size()];
        for (int i = 0; i < characters.size(); i++) {
            charactersArray[i] = characters.get(i);
        }

        return charactersArray;
    }

    public static void main(String[] args) {
        MinimumCharactersForWords minimumCharactersForWords = new MinimumCharactersForWords();
        System.out.println(minimumCharactersForWords.minimumCharactersForWords(
            new String[]{"this", "that", "did", "deed", "them!", "a"}));
        System.out.println(minimumCharactersForWords.minimumCharactersForWords(
            new String[]{"mississippi", "piper", "icing", "ice", "pickle", "piping", "pie", "pi",
                "sassy", "serpent", "python", "ascii", "sister", "mister"}));
    }
}
