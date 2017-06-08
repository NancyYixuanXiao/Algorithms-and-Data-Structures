public class CountAndSay {
    public String countAndSay(int n) {
        int count = 1;
        String res = "1";
        while (count < n) {
            res = getCountSay(res);
            count++;
        }
        return res;
    }
    public String getCountSay(String str) {
        String res =  "";
        int i = 0;
        while (i < str.length()) {
            char tmp = str.charAt(i);
            int count = 0;
            while (i < str.length() && str.charAt(i) == tmp) {
                count++;
                i++;
            }
            res += String.valueOf(count) + String.valueOf(tmp);
        }
        return res;
    }
}
