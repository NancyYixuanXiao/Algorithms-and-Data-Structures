package leetCodeJava;

public class IsPowerOfThree {

	public static boolean isPowerOfThree(int n) {
        
		// solution 1
//		return Integer.toString(n, 3).matches("^10*$");
		
		// solution 2
		// the max power of 3 is 19 within range
		// since 3 is prime, any divisors of 3^19 is a power of 3
		
		return n>0 && (Math.pow(3, 19)) % n == 0;
    }
}
