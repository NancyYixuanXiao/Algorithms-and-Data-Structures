/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(Integer.MIN_VALUE - 1l, root, Integer.MAX_VALUE + 1l);
    }
    public boolean helper(long minVal, TreeNode root, long maxVal) {
        if (root == null) {
            return true;
        }
        if (root.val <= minVal || root.val >= maxVal) {
            return false;
        }
        return helper(minVal, root.left, root.val) && 
               helper(root.val, root.right, maxVal);
    }
}
