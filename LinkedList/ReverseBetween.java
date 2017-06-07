/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        for (int i = 0; i < m - 1; i++) {
            curr = curr.next;
        }
        ListNode mid = curr;
        curr = curr.next;
        ListNode prev = null, next, tail = curr;
        for (int i = 0; i < n - m + 1; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        mid.next = prev;
        tail.next = curr;
        return dummy.next;
    }
}
