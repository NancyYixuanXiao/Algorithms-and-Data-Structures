package leetCodeJava;

public class StrStr {

	public static int strStr(String haystack, String needle) {
        
		if (needle.length()==0) return 0;
		
		for (int i=0; i<haystack.length(); i++)
		{
			if (haystack.charAt(i) == needle.charAt(0) && haystack.length()-i>=needle.length())
			{
				int j = 1;
				System.out.println(i);
				for (; j<needle.length(); j++)
				{
					if (haystack.charAt(i+j) != needle.charAt(j)) break;
				}
				System.out.println(j);
				if (j == needle.length()) return i;
			}
		}
		return -1;
    }
}
