public class FindPairs {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        int i = 0, j = 1;
        while (j < nums.length) {
            if (i >= j || nums[j] - nums[i] < k) {
                j++;
            } else if (nums[j] - nums[i] > k) {
                i++;
            } else {
                res++;
                i++;
                j++;
                while (i < nums.length && nums[i] == nums[i - 1]) {
                    i++;
                }
            }
        }
        return res;
    }
}
