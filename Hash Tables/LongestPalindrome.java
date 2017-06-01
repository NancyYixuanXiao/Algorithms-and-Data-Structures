public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] cnt = new int[256];
        for (char c : s.toCharArray()) {
            cnt[c]++;
        }
        int count = 0;
        for (int c : cnt) {
            count += c / 2 * 2;
        }
        if (count + 1 <= s.length()) {
            return count + 1;
        }
        return count;
    }
}
