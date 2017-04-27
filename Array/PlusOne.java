public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            int d = digits[i] + carry;
            digits[i] = d % 10;
            carry = d / 10;
        }
        if (carry == 0) {
            return digits;
        } else {
            int[] res = new int[len + 1];
            res[0] = 1;
            for (int i = 0; i < len; i++) {
                res[i + 1] = digits[i];
            }
            return res;
        }
    }
}
