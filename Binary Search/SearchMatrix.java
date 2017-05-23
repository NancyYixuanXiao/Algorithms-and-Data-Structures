public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int start = 0, end = rows * cols - 1, mid;
        while (start < end - 1) {
            mid = (start + end) / 2;
            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            } else if (matrix[mid / cols][mid % cols] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[start / cols][start % cols] == target) {
            return true;
        }
        if (matrix[end / cols][end % cols] == target) {
            return true;
        }
        return false;
    }
}
