public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[] row = new int [matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == '1') {
                row[j] = 1;
            }
        }
        int area = findLargestRectangle(row);
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    row[j] += 1;
                } else {
                    row[j] = 0;
                }
            }
            area = Math.max(area, findLargestRectangle(row));
        }
        return area;
    }
    public int findLargestRectangle(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int area = 0;
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < len; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int bar = heights[stack.pop()];
                area = Math.max(area, bar * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int bar = heights[stack.pop()];
            area = Math.max(area, bar * (len - stack.peek() - 1));
        }
        return area;
    }
}
