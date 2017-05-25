public class Trap {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int height1 = height[left], height2 = height[right];
        int res = 0;
        while (left < right) {
            if (height1 < height2) {
                left++;
                if (height[left] < height1) {
                    res += height1 - height[left];
                } else {
                    height1 = height[left];
                }
            } else {
                right--;
                if (height[right] < height2) {
                    res += height2 - height[right];
                } else {
                    height2 = height[right];
                }
            }
        }
        return res;
    }
}
