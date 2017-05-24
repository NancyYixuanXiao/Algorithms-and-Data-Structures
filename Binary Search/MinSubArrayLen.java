public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < preSum.length - 1; i++) {
            int pos = searchLargerThan(preSum, preSum[i] + s);
            if (pos != -1) {
                res = Math.min(res, pos - i);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    // binary searches the first element that is greater or equal to target
    public int searchLargerThan(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1, mid;
        while (start < end - 1) {
            mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] >= target) {
            return start;
        }
        if (nums[end] >= target) {
            return end;
        }
        return -1;
    }
}
