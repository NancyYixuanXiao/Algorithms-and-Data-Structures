public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int sum;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                sum = nums[i] + nums[start] + nums[end];
                if (sum >= target) {
                    end--;
                } else {
                    count += end - start;
                    start++;
                }
            }
        }
        return count;
    }
}
