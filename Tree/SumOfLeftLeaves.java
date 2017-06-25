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
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return ans;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            ans += root.left.val;
        } else {
            ans += sumOfLeftLeaves(root.left);
        }
        ans += sumOfLeftLeaves(root.right);
        return ans;
    }
}

// Solution 2
public class Solution {
    int leftLeavesSum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root.left, true);
        traverse(root.right, false);
        return leftLeavesSum;
    }
    public void traverse(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (isLeft && root.left == null && root.right == null) {
            leftLeavesSum += root.val;
        } else {
            traverse(root.left, true);
            traverse(root.right, false);
        }
    }
}
