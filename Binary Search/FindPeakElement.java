public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = -1, end = nums.length;
        while (start  < end - 1) {
            int mid = (start + end);
            if (get(nums, mid) < get(nums, mid - 1)) {
                end = mid;
            } else if (get(nums, mid) < get(nums, mid + 1)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return get(nums, start) > get(nums, end) ? start : end;
    }
    public int get(int[] nums, int index) {
        if (index < 0 || index >= nums.length) {
            return Integer.MIN_VALUE;
        }
        return nums[index];
    }
}
