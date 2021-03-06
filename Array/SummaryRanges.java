//P.228
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int i = 0;
        while (i < nums.length) {
            int j = i;
            while (j < nums.length - 1 && nums[j] + 1 == nums[j + 1]) {
                j++;
            }
            if (i == j) {
                res.add(nums[i] + ""); // string concatenation
            } else {
                res.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return res;
    }
}
