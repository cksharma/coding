package com.hackerrank.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by cksharma on 5/21/15.
 */
public class Solution {
    static BigInteger byteMin = new BigInteger(Byte.MIN_VALUE + "");
    static BigInteger byteMax = new BigInteger(Byte.MAX_VALUE + "");
    static BigInteger shortMin = new BigInteger(Short.MIN_VALUE + "");
    static BigInteger shortMax = new BigInteger(Short.MAX_VALUE + "");
    static BigInteger intMin = new BigInteger(Integer.MIN_VALUE + "");
    static BigInteger intMax = new BigInteger(Integer.MAX_VALUE + "");
    static BigInteger longMin = new BigInteger(Long.MIN_VALUE + "");
    static BigInteger longMax = new BigInteger(Long.MAX_VALUE + "");

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String str = in.next();
            BigInteger bi = new BigInteger(str);
            List<String> list = new ArrayList<>();
            if (bi.compareTo(byteMin) >= 0 && bi.compareTo(byteMax) <= 0) {
                list.add("* byte");
            }
            if (bi.compareTo(shortMin) >= 0 && bi.compareTo(shortMax) <= 0) {
                list.add("* short");
            }
            if (bi.compareTo(intMin) >= 0 && bi.compareTo(intMax) <= 0) {
                list.add("* int");
            }
            if (bi.compareTo(longMin) >= 0 && bi.compareTo(longMax) <= 0) {
                list.add("* long");
            }
            print(str, list);
        }
    }

    private static void print(String str, List<String> list) {
        if (list.size() == 0) {
            System.out.println(str + " can't be fitted anywhere.");
        } else {
            System.out.println(str + " can be fitted in:");
            for (String item : list)
                System.out.println(item);
        }
    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public String nextLine() {
        String inputLine = "";
        try {
            inputLine = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputLine;
    }
}
