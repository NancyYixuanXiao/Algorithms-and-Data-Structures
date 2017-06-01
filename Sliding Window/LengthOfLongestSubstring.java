public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int[] cnt = new int[256];
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            while (cnt[s.charAt(j)] != 0) {
                cnt[s.charAt(i)]--;
                i++;
            }
            cnt[s.charAt(j)]++;
            max = Math.max(j - i + 1, max);
        }
        return max;
    }
}
