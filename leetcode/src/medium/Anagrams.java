package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    public List<String> anagrams(String[] strs) {
        Map <String, List <Integer>> map = new HashMap<>();
        List <String> list = new ArrayList <>();
        for (int i = 0; i < strs.length; i++) {
        	char[] ch = strs[i].toCharArray();
        	Arrays.sort(ch);
        	String k = new String(ch);
        	List <Integer> cnt = map.get(k);
        	if (cnt == null) {
        		cnt = new ArrayList <>();
        		cnt.add(i);
        		map.put(k, cnt);
        	} else {
        		map.get(k).add(i);
        	}	
        }        
        for (String key : map.keySet()) {
        	if (map.get(key).size() > 1) {
        		for (int index : map.get(key)) {
        			list.add(strs[index]);
        		}
        	}
        }        
    	return list;
    }
    public static void main(String[] args) {
		Anagrams sol = new Anagrams();
		System.out.println(sol.anagrams(new String[] {"abcd", "dcba", "asd"}));
	}
}
