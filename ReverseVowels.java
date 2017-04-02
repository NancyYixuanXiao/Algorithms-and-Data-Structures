package leetCodeJava;

import java.util.Arrays;
import java.util.List;

public class ReverseVowels {

	public static String reverseVowels(String s) {
        
		char[] chars = s.toCharArray();
		int i = 0, j = chars.length - 1;
		List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
				
		char tmp;
		while(i < j)
		{
			while (!vowels.contains(chars[i]) && i < j)
			{
				i++;
			}
			while (!vowels.contains(chars[j]) && j > i)
			{
				j--;
			}
			tmp = chars[i];
			chars[i] = chars[j];
			chars[j] = tmp;
			i++;
			j--;
		}
		
		return String.valueOf(chars);
    }
}
