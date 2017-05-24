public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfsHelper(nums, 0, res, new ArrayList<Integer>());
        return res;
    }
    public void dfsHelper(int[] nums, int start, List<List<Integer>> res, List<Integer> curr) {
        res.add(new ArrayList<Integer>(curr));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            dfsHelper(nums, i + 1, res, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
