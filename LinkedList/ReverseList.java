/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseList {
    // iteratively
    public ListNode reverseListIterative(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    // recursively
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null) {
            return head;
        }
        return reverse(head, null);
    }
    public ListNode reverse(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverse(next, head);
    }
}
