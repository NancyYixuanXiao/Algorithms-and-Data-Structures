package leetCodeJava;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int num_begin = i;
                while (Character.isDigit(s.charAt(i))) {
                    i++;
                }
                stack.push(s.substring(num_begin, i));
            } else if (Character.isLetter(s.charAt(i))) {
                stack.push(Character.toString(s.charAt(i)));
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder ();
                while (!Character.isDigit(stack.peek().charAt(0))) {
                    sb.insert(0, stack.pop());
                }
                int times = Integer.parseInt(stack.pop());
                System.out.println(times + " " + sb);
                StringBuilder res = new StringBuilder ();
                for (int t = 0; t < times; t++) {
                    res.append(sb);
                    System.out.println("t=" + t + " sb=" + sb);
                }
                stack.push(res.toString());
                System.out.println(stack.peek());
            }
            i++;
        }
        String result = "";
        while (!stack.empty()) {
            result = stack.pop() + result;
        }
        return result;
    }
}
