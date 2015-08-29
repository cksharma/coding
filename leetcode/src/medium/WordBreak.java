package medium;

import java.util.*;

/**
 * Created by cksharma on 8/20/15.
 */
public class WordBreak {
    private Map<String, Boolean> visited = new HashMap<>();
    private Set<String> wordDict;
    private String s;
    private int n;
    private boolean flag;
    private int cnt;

    private boolean solve(int start) {
        if (start >= n ) {
            return true;
        }

        for (String item : wordDict) {
            String temp = s.substring(start);
            if (temp.startsWith(item) && cnt < n + 1 ) {
                ++cnt;
                flag = flag || solve(start + item.length());
            }
        }
        return flag;
    }


    public boolean wordBreak(String s, Set<String> wordDict) {
        this.s = s;
        this.n = s.length();
        this.flag = false;
        this.cnt = 0;
        this.wordDict = wordDict;
        return solve(0);
    }

    public static void main(String[] args) {

        WordBreak wordBreak = new WordBreak();

        //Test 1
        String s = "leetcode";
        Set<String> dict = new HashSet<String>();
        dict.add("leet"); dict.add("code");

        long startTime = System.currentTimeMillis();
        System.out.println(wordBreak.wordBreak(s, dict));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);


        s = "abcdef";
        dict = new HashSet<>();
        dict.add("abc");dict.add("b");dict.add("x");dict.add("c");dict.add("y");
        dict.add("de");dict.add("e");dict.add("r");dict.add("ef");dict.add("f");
        startTime = System.currentTimeMillis();
        System.out.println(wordBreak.wordBreak(s, dict));
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);


        s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        dict = new HashSet<>();
        dict.add("a");dict.add("aa");dict.add("aaa");dict.add("aaaa");dict.add("aaaaa");
        dict.add("aaaaaa");dict.add("aaaaaaa");dict.add("aaaaaaaa");dict.add("aaaaaaaaa");
        dict.add("aaaaaaaaaa");
        startTime = System.currentTimeMillis();
        System.out.println(wordBreak.wordBreak(s, dict));
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);


        //Test 2
        s = "acaaaaabbbdbcccdcdaadcdccacbcccabbbbcdaaaaaadb";
        dict = new HashSet<String>();
        dict.add("abbcbda");dict.add("cbdaaa");dict.add("b");dict.add("dadaaad");dict.add("dccbbbc");
        dict.add("dccadd");dict.add("ccbdbc");dict.add("bbca");dict.add("bacbcdd");dict.add("a");
        dict.add("bacb");dict.add("cbc");dict.add("adc");dict.add("c");dict.add("cbdbcad");
        dict.add("cdbab");dict.add("db");dict.add("abbcdbd");dict.add("bcb");dict.add("bbdab");
        dict.add("aa");dict.add("bcadb");dict.add("bacbcb");dict.add("ca");dict.add("dbdabdb");
        dict.add("ccd");dict.add("acbb");dict.add("bdc");dict.add("acbccd");dict.add("d");
        dict.add("cccdcda");dict.add("dcbd");dict.add("cbccacd");dict.add("ac");dict.add("cca");
        dict.add("aaddc");dict.add("dccac");dict.add("ccdc");dict.add("bbbbcda");dict.add("ba");
        dict.add("adbcadb");dict.add("dca");dict.add("abd");dict.add("bdbb");dict.add("ddadbad");
        dict.add("badb");dict.add("ab");dict.add("aaaaa");dict.add("acba");dict.add("abbb");
        startTime = System.currentTimeMillis();
        wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak(s, dict));
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
