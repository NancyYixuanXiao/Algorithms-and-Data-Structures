/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root, root.val);
        return sum;
    }
    public void traverse(TreeNode root, int currSum) {
        if (root.left == null && root.right == null) {
            sum += currSum;
            return;
        }
        if (root.left != null) {
            traverse(root.left, currSum * 10 + root.left.val);
        }
        if (root.right != null) {
            traverse(root.right, currSum * 10 + root.right.val);
        }
    }
}
