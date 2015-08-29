package medium;

import java.util.HashMap;
import java.util.Map;

class TrieAddSearch {
    boolean isLastChar;
    Map<Character, TrieAddSearch> trieMap = new HashMap<>();

    TrieAddSearch() {

    }
}

public class WordDictionary {

    private TrieAddSearch root;

    WordDictionary() {
        root = new TrieAddSearch();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word == null || word.length() == 0) return;
        TrieAddSearch trie = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (trie.trieMap.containsKey(ch) == false) {
                trie.trieMap.put(ch, new TrieAddSearch());
            }
            if ( i == word.length() - 1) {
                trie.isLastChar = true;
            }
            trie = trie.trieMap.get(ch);
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieAddSearch trie = root;
        return solve(word, 0, trie, false);
    }

    public boolean solve(String word, int index, TrieAddSearch trie, boolean isLastChar) {
        if (trie == null) return false;

        if (index == word.length()  ) return isLastChar;

        char ch = word.charAt(index);
        if (ch == '.') {
            boolean flag = false;
            for (char item : trie.trieMap.keySet()) {
                flag = flag || solve(word, index + 1, trie.trieMap.get(item), trie.isLastChar);
            }
            return flag;
        } else {
            return solve(word, index + 1, trie.trieMap.get(ch), trie.isLastChar);
        }
    }


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();

        //Test 1
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));

        //Test 2
        System.out.println();
        WordDictionary wordDictionary1 = new WordDictionary();
        wordDictionary1.addWord("at");
        wordDictionary1.addWord("and");
        wordDictionary1.addWord("an");
        wordDictionary1.addWord("add");
        System.out.println(wordDictionary1.search("a"));
        System.out.println(wordDictionary1.search(".at"));
        wordDictionary1.addWord("bat");
        System.out.println(wordDictionary1.search(".at"));
        System.out.println(wordDictionary1.search("an."));
        System.out.println(wordDictionary1.search("a.d."));
        System.out.println(wordDictionary1.search("b."));
        System.out.println(wordDictionary1.search("a.d"));
        System.out.println(wordDictionary1.search("."));

    }
}
