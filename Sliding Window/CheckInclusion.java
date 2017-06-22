public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[26];
        for (char c : s1.toCharArray()) {
            cnt[c - 'a']++;
        }
        int i = 0, j = 0, count = s1.length();
        while (j < s2.length()) {
            if (cnt[s2.charAt(j) - 'a'] > 0) {
                cnt[s2.charAt(j) - 'a']--;
                count--;
                if (count == 0) {
                    return true;
                } 
                j++;
            } else {
                if (count < s1.length()) {
                    cnt[s2.charAt(i) - 'a']++;
                    count++;
                } else {
                    j++;
                }
                i++;
            }
        }
        return false;
    }
}
