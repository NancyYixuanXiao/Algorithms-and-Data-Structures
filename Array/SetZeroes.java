public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean frow = false;
        boolean fcol = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                fcol = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                frow = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                setRowZeros(matrix, i);
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                setColZeros(matrix, i);
            }
        }
        if (frow) {
            setRowZeros(matrix, 0);
        }
        if (fcol) {
            setColZeros(matrix, 0);
        }
    }
    public void setRowZeros(int[][] matrix, int row) {
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
    }
    public void setColZeros(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}
