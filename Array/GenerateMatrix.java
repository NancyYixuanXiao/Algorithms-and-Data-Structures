//P.59

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num;
                num++;
            }
            top++;
            for (int j = top; j <= bottom; j++) {
                res[j][right] = num;
                num++;
            }
            right--;
            if (bottom >= top) {
                for (int i = right; i >= left; i--) {
                    res[bottom][i] = num;
                    num++;
                }
                bottom--;
            }
            if (right >= left) {
                for (int j = bottom; j >= top; j--) {
                    res[j][left] = num;
                    num++;
                }
                left++;
            }
        }
        return res;
    }
}
