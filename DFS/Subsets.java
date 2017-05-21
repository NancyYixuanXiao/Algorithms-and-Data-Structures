public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfsHelper(nums, new ArrayList<Integer>(), 0, res);
        return res;
    }
    public void dfsHelper(int[] nums, List<Integer> curr, int start, List<List<Integer>> res) {
        res.add(new ArrayList<Integer>(curr));
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            dfsHelper(nums, curr, i + 1, res);
            curr.remove(curr.size() - 1);
        }
    }
}
