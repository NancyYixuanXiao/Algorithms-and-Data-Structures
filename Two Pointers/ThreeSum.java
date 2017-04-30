//P.15
// pay attention to eliminate duplicates
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if (k != 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1, j = nums.length - 1; 
            while (i < j) {
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    i++;
                    continue;
                }
                int sum = nums[k] + nums[i] + nums[j];
                if (sum > 0) {
                    j--;
                } else if (sum < 0) {
                    i++;
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[k]);
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    res.add(tmp);
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}
