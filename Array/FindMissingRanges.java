public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int start = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > start) {
                res.add(getRange(start, nums[i] - 1));
            }
            if (nums[i] == Integer.MAX_VALUE) {
                return res;
            }
            start = nums[i] + 1;
        }
        if (start <= upper) {
            res.add(getRange(start, upper));
        }
        return res;
    }
    public String getRange(int lo, int hi) {
        return lo == hi ? lo + "" : lo + "->" + hi;
    }
}
