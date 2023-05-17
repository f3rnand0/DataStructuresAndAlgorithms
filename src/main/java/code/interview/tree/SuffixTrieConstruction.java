package code.interview.tree;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrieConstruction {

    static class TrieNode {

        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {

        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        // Iterate through every possible substring of the input string (considering also the full
        // string), by going through each character (and the subsequent characters) of the string.
        // Also, by starting on the root node, check if the current character is already a children
        // of the current node. If it's not added it to the children map. Then, advance on the next
        // character and so on.
        // O(n^2) T
        // O(n^2) S
        public void populateSuffixTrieFrom(String str) {
            for (int i = 0; i < str.length(); i++) {
                insertSubstringStartingAt(i, str);
            }
        }

        public void insertSubstringStartingAt(int i, String str) {
            TrieNode node = root;
            for (int j = i; j < str.length(); j++) {
                char letter = str.charAt(j);
                if (!node.children.containsKey(letter)) {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                }
                node = node.children.get(letter);
            }
        }

        // Using the same principle as the 'populateSuffixTrieFrom' method, iterate on every
        // character of the input string and check if that character is a child on the current node.
        // Return true if every character is the corresponding child and the final child is the
        // endSymbol. Return false on the opposite.
        // O(m) T, where m is hte length of the input string
        // O(1) S
        public boolean contains(String str) {
            TrieNode node = root;
            for (int i = 0; i < str.length(); i++) {
                char letter = str.charAt(0);
                if (!node.children.containsKey(letter)) {
                    return false;
                }
                node = node.children.get(letter);
            }
            return node.children.containsKey(endSymbol);
        }
    }

}
