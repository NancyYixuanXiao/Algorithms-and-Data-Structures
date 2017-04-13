package leetCodeJava;

public class GetSum {

    public static int getSum(int a, int b) {
        
    	//a^b get the different bits, 0+0->0, 1+1->0 carry 1
    	//a&b get the carry bits after shifting to left 1 bit
//    	return b==0 ? a : getSum(a^b, (a&b)<<1);
    	
    	if (a == 0) return b;
    	if (b == 0) return a;
    	int carry;
    	while (b != 0)
    	{
    		carry = (a&b) << 1;
    		a = a^b;
    		b = carry;
    	}
    	return a;
    }
}
