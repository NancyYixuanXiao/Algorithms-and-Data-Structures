public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = 0;
        for (; i < nums.length - 2; i+=2) {
            if (nums[i + 1] < nums[i]) {
                swap(nums, i, i + 1);
            }
            if (nums[i + 1] < nums[i + 2]) {
                swap(nums, i + 1, i + 2);
            }
        }
        if (i != nums.length - 1 && nums[i + 1] <nums[i]) {
            swap(nums, i, i + 1);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
