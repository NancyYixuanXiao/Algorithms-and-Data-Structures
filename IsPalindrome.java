package leetCodeJava;

public class IsPalindrome {

	public static boolean isPalindrome(String s) {
        
		int i = 0, j = s.length() - 1;
		
		while (i < j)
		{
			while (!Character.isLetterOrDigit(s.charAt(i)) && i<j) i++;
			while (!Character.isLetterOrDigit(s.charAt(j)) && j>i) j--;

			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
			i++;
			j--;
		}
			
		return true;
    }
}
