package leetCodeJava;

import java.util.List;
import java.util.ArrayList;

public class FindAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        
    	List<Integer> ans = new ArrayList<>(); 
    	
    	if (s.length() < p.length()) {
    		return ans;
    	}
    	
    	int[] pChar = new int [26];
    	for (char c : p.toCharArray()) {
    		pChar[c-'a']++;
    	}
    	
    	int left = 0, right = 0, count = p.length();
    	
    	while (right < s.length()) {
    		if (pChar[s.charAt(right++)-'a']-- > 0) {
    			count--;
    		}
    		if (count == 0) {
    			ans.add(left);
    		}
    		if (right - left == p.length() && pChar[s.charAt(left++)-'a']++ >= 0) {
    			count++;
    		}
    	}
    	
    	return ans;
    }
}
