/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FindLeaves {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        traverse(root, res);
        return res;
    }
    public int traverse(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return 0;
        }
        int left = traverse(root.left, res);
        int right = traverse(root.right, res);
        int height = Math.max(left, right) + 1;
        if (res.size() == height - 1) {
            res.add(new ArrayList<>());
        }
        res.get(height - 1).add(root.val);
        return height;
    } 
}
