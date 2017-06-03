public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int[] cnt = new int[n + 1];
        for (int citation : citations) {
            if (citation >= n) {
                cnt[n]++;
            } else {
                cnt[citation]++;
            }
        }
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += cnt[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
