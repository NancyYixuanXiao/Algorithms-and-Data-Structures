//P.11
public class MaxArea {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int area = 0;
        while (i < j) {
            int temp = 0;
            if (height[i] < height[j]) {
                temp = height[i] * (j - i);
                i++;
            } else {
                temp = height[j] * (j - i);
                j--;
            }
            area = Math.max(temp, area);
        }
        return area;
    }
}
