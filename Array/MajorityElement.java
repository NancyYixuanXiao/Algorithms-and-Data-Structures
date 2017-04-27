public class MajorityElement {
    public int majorityElement(int[] nums) {
        // moore voting algorithm
        int major = nums[0];
        int count = 0;
        for (int n : nums) {
            if (count == 0) {
                major = n;
            }
            if (n == major) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
