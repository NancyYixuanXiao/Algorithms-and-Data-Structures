package leetCodeJava;

public class IsPowerOfFour {

	public static boolean isPowerOfFour(int num) {
        
		// solution 1
//		int i = 0;
//		while (true)
//		{
//			if (num == Math.pow(4, i))  return true;
//			if (num < Math.pow(4, i))  return false;
//			i += 1;
//		}
		
		// solution 2
//		return Integer.toString(num, 4).matches("^10*$");
		
		// solution 3
		// first num is a power of 2, and num is a power of 4
		// a power of 4 has 1s only at odd digits
		// binary representation of 0x55555555: 1010101010101010101010101010101
		return num>0 && (num & (num-1))==0 && (num & 0x55555555) == num;
		
    }
}
