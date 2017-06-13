public class MyAtoi {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index == str.length()) {
            return 0;
        }
        int sign = 1;
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        int num = 0;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && str.charAt(index) - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + (str.charAt(index) - '0');
            index++;
        }
        return sign * num;
    }
}
