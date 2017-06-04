public class FrequencySort {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] cnt = new int[256];
        for (char c : s.toCharArray()) {
            cnt[c]++;
        }
        List<Character>[] buckets = new List[s.length() + 1];
        for (int i = 0; i < 256; i++) {
            if (cnt[i] != 0) {
                if (buckets[cnt[i]] == null) {
                    buckets[cnt[i]] = new ArrayList<Character>();
                } 
                buckets[cnt[i]].add((char)i);
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int t = 0; t < i; t++) {
                        res.append(c);
                    }
                }
            }
        }
        return res.toString();
    }
}
