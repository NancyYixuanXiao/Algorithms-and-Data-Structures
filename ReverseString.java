package leetCodeJava;

public class ReverseString {

	public static String reverseString(String s) {
        
		char[] chars = s.toCharArray();
		System.out.println(chars);
		char tmp;
		
		for (int i=0,j=chars.length-1; i<j; i++, j--)
		{
			tmp = chars[i];
			chars[i] = chars[j];
			chars[j] = tmp;
		}
		
		return new String(chars);
    }
}
