//P.287
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int start = 1, end = nums.length - 1;
        while (start < end - 1) {
            int mid = (start + end) / 2;
            if (countSmaller(nums, mid) == mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return countSmaller(nums, start) == start ? end : start;
    }
    public int countSmaller(int[] nums, int val) {
        int count = 0;
        for (int num : nums) {
            if (num <= val) {
                count++;
            }
        }
        return count;
    }
}
