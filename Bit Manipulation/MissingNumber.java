public class MissingNumber {
    public int missingNumber(int[] nums) {
        // 0 ^ N = N
        int res = 0;
        // N ^ x ^ x = N
        // suppose nums = [0, 1, 3], without missing number, the number equals to its index
        // thus xor the number with its index, to eliminate non-missing numbers
        for (int i = 0; i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }
        // there should be (nums.length + 1) numbers, thus the last index is nums.length
        return res ^ nums.length;
    }
}
