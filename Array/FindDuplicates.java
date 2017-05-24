public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int n : nums) {
            int index = Math.abs(n) - 1;
            if (nums[index] >= 0) {
                nums[index] = -nums[index];
            } else {
                res.add(index + 1);
            }
        }
        return res;
    }
}
