public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper(candidates, target, res, new ArrayList<Integer>(), 0, 0);
        return res;
    }
    public void helper(int[] candidates, int target, List<List<Integer>> res,
                       List<Integer> curr, int start, int currSum) {
        if (currSum == target) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }          
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (currSum + candidates[i] > target) {
                break;
            }
            curr.add(candidates[i]);
            helper(candidates, target, res, curr, i + 1, currSum + candidates[i]);
            curr.remove(curr.size() - 1);
        }
    }
}
