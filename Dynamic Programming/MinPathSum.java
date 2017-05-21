public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];
        f[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int i = m - 2; i >= 0; i--) {
            f[i][n - 1] = f[i + 1][n - 1] + grid[i][n - 1];
        }
        for (int j = n - 2; j >= 0; j--) {
            f[m - 1][j] = f[m - 1][j + 1] + grid[m - 1][j];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                f[i][j] = Math.min(f[i + 1][j], f[i][j + 1]) + grid[i][j];
            }
        }
        return f[0][0];
    }
}
