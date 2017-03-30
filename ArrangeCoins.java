package leetCodeJava;

public class ArrangeCoins {

    public static int arrangeCoins(int n) {
     
    	// solution 1
//    	int start = 0, end = n/2;
//    	
//    	while (start <= end)
//    	{
//    		int mid = (start + end) >>> 1;
//    		
//    		if (0.5*mid*mid+0.5*mid <= n) start = mid + 1;// 0.5* is important here, avoiding overflow problem
//    		else end = mid - 1;
//    		
//    	}
//    	
//    	return start-1;   	
    	
    	return (int) (0.5 * (Math.sqrt(1+8.0*n)-1));
    }
}
