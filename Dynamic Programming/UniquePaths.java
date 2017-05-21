public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][n - 1] = 1;
        }
        for (int j = 0; j < n; j++) {
            f[m - 1][j] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                f[i][j] = f[i + 1][j] + f[i][j + 1];
            }
        }
        return f[0][0];
    }
}
