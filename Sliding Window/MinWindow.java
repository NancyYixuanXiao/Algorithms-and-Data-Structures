public class MinWindow {
    public String minWindow(String s, String t) {
        int[] cnt = new int[256];
        for (char c : t.toCharArray()) {
            cnt[c]++;
        }
        int count = t.length();
        int i = 0;
        String res = s;
        boolean found = false;
        for (int j = 0; j < s.length(); j++) {
            if (cnt[s.charAt(j)] > 0) {
                count--;
            }
            cnt[s.charAt(j)]--;
            if (count == 0 && res.length() >= j - i + 1) {
                res = s.substring(i, j + 1);
                found = true;
            }
            while (count == 0) {
                if (res.length() > j - i + 1) {
                    res = s.substring(i, j + 1);
                }
                cnt[s.charAt(i)]++;
                if (cnt[s.charAt(i)] > 0) {
                    count++;
                }
                i++;
            }
        }
        return found ? res : "";
    }
}
