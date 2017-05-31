public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = 0;
        boolean[] isNotPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i]) {
                count++;
            }
            for (int j = 2; i * j < n; j++) {
                isNotPrime[i * j] = true;
            }
        }
        return count;
    }
}
