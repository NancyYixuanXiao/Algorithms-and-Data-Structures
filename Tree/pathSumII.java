/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class pathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        traverse(root, sum, res, new ArrayList<>());
        return res;
    }
    public void traverse(TreeNode root, int sum, List<List<Integer>> res, List<Integer> curr) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        curr.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(curr));
            curr.remove(curr.size() - 1);
            return;
        }
        traverse(root.left, sum, res, curr);
        traverse(root.right, sum, res, curr);
        curr.remove(curr.size() - 1);
    }
}
