package medium;

import java.util.HashMap;

/**
 * Created by cksharma on 8/19/15.
 */
class TrieNode {
    // Initialize your data structure here.
    HashMap<Character, TrieNode> hMap = new HashMap<>();
    boolean isLastCharacter;

    public TrieNode() {

    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "hMap=" + hMap +
                ", isLastCharacter=" + isLastCharacter +
                '}';
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            HashMap<Character, TrieNode> hMap = node.hMap;
            if (hMap.containsKey(ch)) {
                node = hMap.get(ch);
            } else {
                TrieNode tNode = new TrieNode();
                node.hMap.put(ch, tNode);
                node = tNode;

            }
            if ( i == word.length() - 1) {
                node.isLastCharacter = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.hMap.containsKey(ch) == false) return false;
            node = node.hMap.get(ch);
        }
        return node.isLastCharacter;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.hMap.containsKey(ch) == false) return false;
            node = node.hMap.get(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        System.out.println(trie.search("ab"));
        System.out.println(trie.startsWith("ab"));
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
