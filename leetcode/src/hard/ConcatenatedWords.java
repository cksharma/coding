package hard;

import java.util.*;

public class ConcatenatedWords {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        List<String> result = new ArrayList<>();
        Map<String, Boolean> memo = new HashMap<>();

        for (String word : words) {
            if (canForm(word, wordSet, memo)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean canForm(String word, Set<String> wordSet, Map<String, Boolean> memo) {
        if (memo.containsKey(word)) {
            return memo.get(word);
        }

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (wordSet.contains(prefix)) {
                if (wordSet.contains(suffix) || canForm(suffix, wordSet, memo)) {
                    memo.put(word, true);
                    return true;
                }
            }
        }

        memo.put(word, false);
        return false;
    }

    public static void main(String[] args) {
        ConcatenatedWords solver = new ConcatenatedWords();

        // Example 1
        String[] words1 = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println("Example 1 Output: " + solver.findAllConcatenatedWordsInADict(words1));
        // Expected: ["catsdogcats","dogcatsdog","ratcatdogcat"] (order may vary)

        // Example 2
        String[] words2 = {"cat","dog","catdog"};
        System.out.println("Example 2 Output: " + solver.findAllConcatenatedWordsInADict(words2));
        // Expected: ["catdog"]
    }
}
