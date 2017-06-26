/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = null;
    public BSTIterator(TreeNode root) {
        curr = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        if (hasNext()) {
            TreeNode tmp = stack.pop();
            curr = tmp.right;
            return tmp.val;
        }   
        return 0;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
