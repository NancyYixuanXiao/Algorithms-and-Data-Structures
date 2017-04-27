public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        // keep moving numbers to its corresponding index
        for (int i = 0; i < n; i++) {
            int saved = -1;
            int j = i;
            while (j >= 0 && nums[j] != j + 1) {
                int tmp = nums[j];
                nums[j] = saved;
                if (tmp == -1) {
                    break;
                }
                saved = nums[tmp - 1];
                nums[tmp - 1] = tmp;
                j = saved - 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
