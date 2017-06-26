/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FindMode {
    int max = 0;
    TreeNode prev = null;
    int count = 1;
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverse(root.left, list);
        if (prev != null) {
            if (prev.val == root.val) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count > max) {
            list.clear();
            list.add(root.val);
            max = count;
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root;
        traverse(root.right, list);
    }
}
