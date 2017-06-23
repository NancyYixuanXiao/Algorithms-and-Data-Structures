public class LengthOfLongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int res = 0;
        int i = 0;
        int count = 0;
        int[] cnt = new int[256];
        for (int j = 0; j < s.length(); j++) {
            if (cnt[s.charAt(j)] == 0) {
                count++;
            }
            cnt[s.charAt(j)]++;
            while (count > 2) {
                cnt[s.charAt(i)]--;
                if (cnt[s.charAt(i)] == 0) {
                    count--;
                }
                i++;
            }
            if (res < j - i + 1) {
                res = j - i + 1;
            }
        }
        return res;
    }
}
