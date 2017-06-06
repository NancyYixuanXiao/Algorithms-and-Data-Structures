/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode i = l1, j = l2;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (i != null && j != null) {
            if (i.val < j.val) {
                prev.next = i;
                i = i.next;
            } else {
                prev.next = j;
                j = j.next;
            }
            prev = prev.next;
        }
        if (i != null) {
            prev.next = i;
        }
        if (j != null) {
            prev.next = j;
        }
        return dummy.next;
    }
}
