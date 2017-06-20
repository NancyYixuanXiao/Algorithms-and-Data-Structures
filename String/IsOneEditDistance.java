public class Solution {
    public boolean IsOneEditDistance(String s, String t) {
        if (s.length() > t.length()) {
            return isOneEditDistance(t, s);
        }
        if (t.length() - s.length() > 1) {
            return false;
        }
        int i = 0, j = 0;
        while (i < s.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                return s.length() == t.length() ? s.substring(i + 1).equals(t.substring(j + 1)) 
                                                : s.substring(i).equals(t.substring(j + 1));
            }
            i++;
            j++;
        }
        return j == t.length() - 1;
    }
}
