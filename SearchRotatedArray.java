package leetCodeJava;

public class SearchRotatedArray {

	public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0, end = nums.length - 1, mid;
        while (start < end - 1) {
            mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return true;
            }
            if (nums[mid] > nums[start]) {
                if (target <= nums[mid] && target >= nums[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[mid] < nums[start]) {
                if (target <= nums[end] && nums[mid] <= target) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                start++;
            }
        }
        if (nums[start] == target || nums[end] == target) {
        	System.out.println("here");
            return true;
        }
        return false;
    }
}
