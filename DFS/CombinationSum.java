public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        backtrack(candidates, target, res, new ArrayList<Integer>(), 0, 0);
        return res;
    }
    public void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> curr, int start, int sum) {
        if (sum == target) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                continue;
            }
            curr.add(candidates[i]);
            backtrack(candidates, target, res, curr, i, sum + candidates[i]);
            curr.remove(curr.size() - 1);
        }
    }
}
