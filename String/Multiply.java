public class Multiply {
    public String multiply(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        }
        String res = "";
        int l = num2.length();
        for (int i = 0; i < l; i++) {
            res = add(res, multiplyDigit(num1, num2.charAt(l - 1 - i), i));
        }
        return res;
    }
    public String multiplyDigit(String num1, char d, int zeros) {
        StringBuilder res = new StringBuilder();
        if (d == '0') {
            return "0";
        }
        int carry = 0;
        int digit = d - '0';
        for (int i = num1.length() - 1; i >= 0; i--) {
            int tmp = (num1.charAt(i) - '0') * digit + carry;
            res.insert(0, tmp % 10);
            carry = tmp / 10;
        }
        if (carry != 0) {
            res.insert(0, carry);
        }
        for (int z = 0; z < zeros; z++) {
            res.append('0');
        }
        return res.toString();
    }
    public String add(String num1, String num2) {
        StringBuilder res =  new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry == 1) {
            int d1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int d2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int d = d1 + d2 + carry;
            res.insert(0, d % 10);
            carry = d / 10;
        }
        return res.toString();
    }
}
