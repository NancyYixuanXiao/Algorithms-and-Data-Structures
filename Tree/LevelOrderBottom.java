/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        traverse(root, res, 1);
        return res;
    }
    public void traverse(TreeNode root, List<List<Integer>> res, int depth) {
        if (root == null) {
            return;
        }
        if (res.size() == depth - 1) {
            res.add(0, new ArrayList<Integer>());
        }
        res.get(res.size() - depth).add(root.val);
        traverse(root.left, res, depth + 1);
        traverse(root.right, res, depth + 1);
    }
}
