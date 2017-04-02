package leetCodeJava;

public class SearchInsert {
	public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = nums.length - 1, mid;
        while (start < end - 1) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        System.out.printf("start = %d end = %d\n", start, end);
        if (target > nums[end]) {
        	return nums.length;
        } else if (target < nums[start]) {
        	return 0;
        } else {
        	return start + 1;
        }
    }
}
