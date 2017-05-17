public class SearchInRotatedSortedArray {
    public int searchInRotatedSortedArray(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start < end - 1) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } 
            if (nums[mid] < nums[end]) {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
