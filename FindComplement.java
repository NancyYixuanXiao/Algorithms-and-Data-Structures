package leetCodeJava;

public class FindComplement {

    public static int findComplement(int num) {
    	
    	// built-in function return the highest 1-bit, left-shift 1 bit and minus 1 to get the 
    	int mask = (Integer.highestOneBit(num) << 1) -1;
    	System.out.println(mask);
    	num = ~num;
    	System.out.println(num);
    	return num & mask;
    }
}
