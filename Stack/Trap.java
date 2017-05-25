public class Trap {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int lower = height[stack.pop()];
                if (!stack.empty()) {
                    int upper = Math.min(height[stack.peek()], height[i]);
                    res += (upper - lower) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return res;
    }
}
