package leetCodeJava;

import java.util.Arrays;

public class IsAnagram {

    public static boolean isAnagram(String s, String t) {
     
    	// solution 1
//    	if (s.length() != t.length()) return false;
//    	
//    	int[] cnt = new int [26];
//    	
//    	for (int i=0; i<s.length(); i++)
//    	{
//    		cnt[s.charAt(i)-'a']++;
//    		cnt[t.charAt(i)-'a']--;
//    	}
//    	
//    	for (int i=0; i<26; i++)
//    	{
//    		if (cnt[i] != 0) return false;
//    	}
//    	
//    	return true;
    	
    	if (s.length() != t.length()) return false;
    	
    	char[] cs = s.toCharArray();
    	char[] ct = s.toCharArray();
    	Arrays.sort(cs);
    	Arrays.sort(ct);
    	return Arrays.equals(cs, ct);
    }
}
