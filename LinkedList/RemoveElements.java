/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, i = head;
        while (i != null) {
            if (i.val == val) {
                i = i.next;
                prev.next = i;
            } else {
                prev = prev.next;
                i = i.next;
            }
        }
        return dummy.next;
    }
}
