/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSumIII {
    public int pathSumIII(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int ans = helper(root, sum);
        ans += pathSum(root.left, sum);
        ans += pathSum(root.right, sum);
        return ans;
    }
    public int helper(TreeNode root, int sum) {
        int ans = 0;
        if (root != null && root.val == sum) {
            ans++;
        }
        if (root.left != null) {
            ans += helper(root.left, sum - root.val);
        }
        if (root.right != null) {
            ans += helper(root.right, sum - root.val);
        }
        return ans;
    }
}
