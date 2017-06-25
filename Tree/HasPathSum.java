/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// Solution 1
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        boolean left = root.left == null ? false : hasPathSum(root.left, sum - root.val);
        boolean right = root.right == null ? false :  hasPathSum(root.right, sum - root.val);
        return left || right;
    }
}

// Solution 2
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return helper(root, sum);
    }
    public boolean helper(TreeNode root, int sum) {
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        boolean left = root.left == null ? false : helper(root.left, sum - root.val);
        boolean right = root.right == null ? false : helper(root.right, sum - root.val);
        return left || right;
    }
}
