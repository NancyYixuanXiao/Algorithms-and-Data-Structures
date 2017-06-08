/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (true) {
            int i = 0;
            ListNode tail = curr;
            for (; i < k && tail != null && tail.next != null; i++) {
                tail = tail.next;
            }
            if (i != k) {
                break;
            }
            ListNode next = tail.next;
            tail.next = null;
            ListNode nextCurr = curr.next;
            curr.next = reverse(curr.next, next);
            curr = nextCurr;
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode head, ListNode previous) {
        ListNode prev = previous, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
