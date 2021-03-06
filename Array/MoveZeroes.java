// two pointers
// i point to the position of next non-zero element
// j traverse the array
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
}
