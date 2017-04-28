public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        for (int i = -1, j = 0; j < nums.length; j++) {
            if (nums[j] != 1) {
                i = j;
            }
            res = Math.max(res, j - i);
        }
        return res;
    }
}
