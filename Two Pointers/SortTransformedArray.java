public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1;
        if (a >= 0) {
            for (int i = res.length - 1; i >= 0; i--) {
                if (f(nums[left], a, b, c) > f(nums[right], a, b, c)) {
                    res[i] = f(nums[left], a, b, c);
                    left++;
                } else {
                    res[i] = f(nums[right], a, b, c);
                    right--;
                }
            }
        } else {
            for (int i = 0; i < res.length; i++) {
                if (f(nums[left], a, b, c) < f(nums[right], a, b, c)) {
                    res[i] = f(nums[left], a, b, c);
                    left++;
                } else {
                    res[i] = f(nums[right], a, b, c);
                    right--;
                }
            }
        }
        return res;
    }
    public int f(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
