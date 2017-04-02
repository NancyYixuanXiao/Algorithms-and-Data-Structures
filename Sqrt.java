package leetCodeJava;

public class Sqrt {

	public static int sqrt(int x) {
        // write your code here
        if (x == 0) {
            return 0;
        }
        long start = 1, end = x;
        long mid;
        while (start < end - 1) {
            mid = start + (end - start) / 2;
            System.out.printf("%d  %d  %d\n", start, mid, end);
            if (mid * mid == x) {
            	System.out.println("found");
                return (int)mid;
            }
            if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return (int)start;
    }
}
