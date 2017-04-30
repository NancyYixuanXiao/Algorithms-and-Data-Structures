//P.238
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        // traverse the array twice, forward and backword to get the accumulated product from left and right
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = right * res[i];
            right *= nums[i];
        }
        return res;
    }
}
