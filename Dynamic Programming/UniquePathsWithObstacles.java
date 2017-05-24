public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        int i = n - 1;
        while (i >= 0 && obstacleGrid[m - 1][i] == 0) {
            f[m - 1][i--] = 1;
        }
        while (i >= 0) {
            f[m - 1][i--] = 0;
        }
        i = m - 1;
        while (i >= 0 && obstacleGrid[i][n - 1] == 0) {
            f[i--][n - 1] = 1;
        }
        while (i >= 0) {
            f[i--][n - 1] = 0;
        }
        for (i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    f[i][j] = f[i + 1][j] + f[i][j + 1];
                }
            }
        }
        return f[0][0];
    }
}
