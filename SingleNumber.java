package leetCodeJava;

public class SingleNumber {

	public static int singleNumber(int[] nums) {
        
        // bitwise XOR: (1) n^0 = n (2) n^n = 0
		// if n is the single number
		// then n^n1^n1^n2^n2... = n^0 = n
		int ans = 0;
		for (int i=0; i<nums.length; i++)
		{
			ans ^= nums[i];
		}
		
		return ans;
    }
}
