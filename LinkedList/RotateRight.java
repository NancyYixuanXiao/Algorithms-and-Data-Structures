/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        tail.next = head;
        ListNode mid = head;
        for (int i = 0; i < len - k % len - 1; i++) {
            mid = mid.next;
        }
        ListNode newHead = mid.next;
        mid.next = null;
        return newHead;
    }
}
