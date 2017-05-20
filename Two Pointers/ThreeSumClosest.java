public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        int sum = closest;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(closest - target) > Math.abs(sum - target)) {
                    closest = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    break;
                }
            }
        }
        return closest;
    }
}
