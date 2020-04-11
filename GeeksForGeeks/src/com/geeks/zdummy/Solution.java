package com.geeks.zdummy;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    private static boolean isValid(String word) {
        boolean ans = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') continue;
            return false;
        }
        return ans && word.length() > 0;
    }

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        Map<String, Integer> wordMap = new TreeMap<>();
        int[] ch = new int[26];
        int N = 0;
        while (ss.hasNext()) {
            String word = ss.next();
            if (isValid(word) == false) continue;
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
            for (int j = 0; j < word.length(); j++) {
                ch[word.charAt(j) - 'a']++;
            }
            N++;
        }
        System.out.println(N);
        System.out.println("words");
        for (String key : wordMap.keySet()) {
            System.out.println(key + " " + wordMap.get(key));
        }
        System.out.println("letters");
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.println(c + " " + ch[c - 'a']);
        }
    }
}
