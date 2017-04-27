public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int start = 0, end = n, mid;
        while (start < end - 1) {
            mid = (start + end) / 2;
            if (countSmaller(nums, mid) == mid + 1) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (countSmaller(nums, start) != start + 1) {
            return start;
        }
        return end;
    }
    public int countSmaller(int[] nums, int val) {
        int count = 0;
        for (int n : nums) {
            if (n <= val) {
                count++;
            }
        }
        return count;
    }
}
