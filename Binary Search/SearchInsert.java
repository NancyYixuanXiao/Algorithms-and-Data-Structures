public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        // can assume no duplicates in array
        int start = 0, end = nums.length - 1;
        while (start < end - 1) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] >= target) {
            return start;
        }
        if (nums[end] < target) {
            return end + 1;
        }
        return start + 1;
    }
}
