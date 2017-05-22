public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        return new int[] {
            searchFirstPosition(nums, target),
            searchLastPosition(nums, target)
        };
    }
    public int searchFirstPosition(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        while (start < end - 1) {
            mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
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
    public int searchLastPosition(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        while (start < end - 1) {
            mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}
