package leetCodeJava;

public class StrStrII {
	
    public static int strStr2(String source, String target) {
        // Write your code here
        if (source == null || target == null) {
            return -1;
        }
        int m = target.length();
        if (m == 0) {
            return 0;
        }
        int BASE = 1000000;
        int targetHash = 0;
        for (int i = 0; i < m; i++) {
        	targetHash = (targetHash * 31 + target.charAt(i)) % BASE;
        }
        System.out.printf("targetHash = %d \n", targetHash);
        int power = 1;
        for (int i = 0; i < m; i++) {
            power = (power * 31) % BASE;
        }
        int hash = 0;
        for (int i = 0; i < source.length(); i++) {
        	System.out.println(source.charAt(i));
            hash = (hash * 31 + source.charAt(i)) % BASE;
            if (i >= m) {
            	System.out.println(source.charAt(i-m));
                hash = hash - (source.charAt(i - m) * power) % BASE;
                if (hash < 0) {
                    hash += BASE;
                }
            }
            System.out.printf("hash = %d\n", hash);
            if (hash == targetHash) {
                if (source.substring(i - m + 1, i + 1).equals(target)) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }
    
}
