public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] cnt = new int[26];
        for (char c : p.toCharArray()) {
            cnt[c - 'a']++;
        }
        int len = p.length();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            cnt[s.charAt(j) - 'a']--;
            if (cnt[s.charAt(j) - 'a'] >= 0) {
                len--;
            }
            while (len == 0) {
                if (j - i + 1 == p.length()) {
                    res.add(i);
                }
                cnt[s.charAt(i) - 'a']++;
                if (cnt[s.charAt(i) - 'a'] > 0) {
                    len++;
                }
                i++;
            }
        }
        return res;
    }
}
