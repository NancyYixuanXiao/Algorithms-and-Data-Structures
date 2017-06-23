public class MySqrt {
    public int mySqrt(int x) {
        int start = 1, end = x, mid; 
        while (start < end - 1) {
            mid = start + (end - start) / 2;
            long product = (long)mid * mid;
            if (product == x) {
                return mid;
            } else if (product > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if ((long)end * end <= x) {
            return end;
        }
        return start;
    }
}
