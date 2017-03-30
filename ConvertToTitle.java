package leetCodeJava;

public class ConvertToTitle {

    public static String convertToTitle(int n) {
     
    	StringBuilder s = new StringBuilder ();
    	
    	while (n > 0)
    	{
    		s.insert(0, (char)('A' + (--n) % 26));
    		n /= 26;
    	}
    	
    	return s.toString();
    }
}
