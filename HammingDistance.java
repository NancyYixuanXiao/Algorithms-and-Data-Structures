package leetCodeJava;

public class HammingDistance {
	
	public static int hammingDistance(int x, int y) {
        
//		method 1: using java function bitCount
//		return Integer.bitCount(x ^ y);
		
//		method 2
		int xor = x ^ y;
		int count = 0;
		
		for (int i=0; i<32; i++)
		{
			count += (xor & 1);
			xor >>= 1;
		}
		
		return count;
    }
}
