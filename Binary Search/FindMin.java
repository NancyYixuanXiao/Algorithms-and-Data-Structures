//P.153
// assume no duplicates
public class FindMin {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        int pivot = nums[nums.length - 1];
        while (start < end - 1) {
            int mid = (start + end) / 2;
            if (nums[mid] < pivot) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }
}
