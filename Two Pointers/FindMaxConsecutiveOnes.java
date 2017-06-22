public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = -1, flipped = -1;
        int res = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                i = flipped;
                flipped = j;
            }
            res = Math.max(j - i, res);
        }
        return res;
    }
}
