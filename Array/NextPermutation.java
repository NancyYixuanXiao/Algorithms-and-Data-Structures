public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length - 1;
        while (i > 0) {
            if (nums[i] > nums[i - 1]){
                break;
            }
            i--;
        }
        if (i != 0) {
            int j = nums.length - 1;
            for (; j >= i; j--) {
                if (nums[j] > nums[i - 1]) {
                    break;
                }
            }
            swap(nums, i - 1, j);
        }
        int t = 0;
        while (i + t < nums.length - 1 - t) {
            swap(nums, i + t, nums.length - 1 - t);
            t++;
        }
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
