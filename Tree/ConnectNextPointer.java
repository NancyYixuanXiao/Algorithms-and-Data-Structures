/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class ConnectNextPointer {
    public void connect(TreeLinkNode root) {
        TreeLinkNode curr = root, parent = null, head = root;
        boolean isRight = true;
        while (curr != null) {
            if (parent == null) {
                curr.next = null;
                parent = head;
                curr = head.left;
                head = head.left;
                isRight = true;
            } else if (isRight) {
                curr.next = parent.right;
                parent = parent.next;
                curr = curr.next;
                isRight = false;
            } else {
                curr.next = parent.left;
                curr = curr.next;
                isRight = true;
            }
        }
    }
}
