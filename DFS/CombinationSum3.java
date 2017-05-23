public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < 6) {
            return res;
        }
        helper(n, k, 1, 0, res, new ArrayList<Integer>());
        return res;
    }
    public void helper(int n, int k, int start, int currSum, 
                       List<List<Integer>> res, List<Integer> curr) {
        if (currSum == n && curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }          
        for (int i = start; i < 10; i++) {
            if (currSum + i <= n && curr.size() < k) {
                curr.add(i);
                helper(n, k, i + 1, currSum + i, res, curr);
                curr.remove(curr.size() - 1);
            } else {
                break;
            }
        }
    }
}
