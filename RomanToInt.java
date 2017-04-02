package leetCodeJava;

import java.util.Map;
import java.util.HashMap;

public class RomanToInt {

    public static int romanToInt(String s) {
        
    	int ans = 0;
    	int[] ret = new int [s.length()];
    	Map<Character, Integer> conv = new HashMap<>();
    	
    	conv.put('I', 1);
    	conv.put('V', 5);
    	conv.put('X', 10);
    	conv.put('L', 50);
    	conv.put('C', 100);
    	conv.put('D', 500);
    	conv.put('M', 1000);
    	
    	for (int i=0; i<s.length(); i++) ret[i] = conv.get(s.charAt(i));
    	
    	for (int i=0; i<ret.length-1; i++)
    	{
    		if (ret[i] < ret[i+1]) ans -= ret[i];
    		else ans += ret[i];
    	}
    	
    	return ans+ret[ret.length-1];
    }
}
