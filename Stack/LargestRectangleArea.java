public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        int len = heights.length;
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
