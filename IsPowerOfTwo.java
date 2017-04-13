package leetCodeJava;

public class IsPowerOfTwo {
	
	public static boolean isPowerOfTwo(int n) {
		
		//solution 1 O(n)
//		System.out.println(Integer.toBinaryString(n));
//		return Integer.bitCount(n) == 1;
		
		//solution 2 iterative O(log n)
//		if (n == 0)	return false;
//			
//		while (n%2 == 0)
//		{
//			n /= 2;
//		}
//		return n == 1;
		
		//solution 3 recursive O(log n)
//		return n>0 && ((n==1) || (n%2==0 && isPowerOfTwo(n/2)));
		
		//solution 4 O(1)
		//if n = 0...010...0, then n-1 = 0...01...1, so that n&(n-1)=0
		return n > 0 && (n&(n-1)) == 0;
    }
}
