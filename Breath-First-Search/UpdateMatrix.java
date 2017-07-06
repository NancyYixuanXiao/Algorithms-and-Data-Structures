public class UpdateMatrix {
    int[] dX = {0, 0, -1, 1};
    int[] dY = {1, -1, 0, 0};
    class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<Coordinate> pq = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = Integer.MAX_VALUE;
                } else {
                    pq.offer(new Coordinate(i, j));
                }
            }
        }
        while (!pq.isEmpty()) {
            Coordinate curr = pq.poll();
            for (int d = 0; d < 4; d++) {
                if (isValid(matrix, curr.x + dX[d], curr.y + dY[d]) && 
                    matrix[curr.x + dX[d]][curr.y + dY[d]] > matrix[curr.x][curr.y] + 1) {
                    Coordinate adj = new Coordinate(curr.x + dX[d], curr.y + dY[d]);
                    pq.offer(adj);
                    matrix[adj.x][adj.y] = matrix[curr.x][curr.y] + 1;
                }
            }
        }
        return matrix;
    }
    public boolean isValid(int[][] matrix, int x, int y) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
            return false;
        }
        return matrix[x][y] != 0;
    }
}
