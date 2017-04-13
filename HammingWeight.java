package leetCodeJava;

public class HammingWeight {
	
	public static int hammingWeight(int n) {
		
		//solution 1
//        return Integer.bitCount(n);
        
        //solution 2
		int count = 0;
				
		for (int i=0; i<32; i++)
		{
			count += (n & 1);
			n >>>= 1; // >>> unsigned shifting; >> signed shifting
		}
		
		return count;
    }
}
