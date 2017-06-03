public class Multiply {
    private class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int k = B.length;
        int n = B[0].length;
        Map<Coordinate, Integer> mapA = new HashMap<>();
        Map<Coordinate, Integer> mapB = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                if (A[i][j] != 0) {
                    mapA.put(new Coordinate(i, j), A[i][j]);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (B[i][j] != 0) {
                    mapB.put(new Coordinate(i, j), B[i][j]);
                }
            }
        }
        int[][] res = new int[m][n];
        for (Coordinate keyA : mapA.keySet()) {
            for (Coordinate keyB: mapB.keySet()) {
                if (keyA.y == keyB.x) {
                    res[keyA.x][keyB.y] += mapA.get(keyA) * mapB.get(keyB);
                }
            }
        }
        return res;
    }
}
