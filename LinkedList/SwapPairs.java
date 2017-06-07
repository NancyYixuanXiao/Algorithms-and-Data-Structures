/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr != null && curr.next != null && curr.next.next != null) {
            ListNode odd = curr.next;
            ListNode nextOdd = odd.next.next;
            curr.next = odd.next;
            odd.next.next = odd;
            odd.next = nextOdd;
            curr = odd;
        }
        return dummy.next;
    }
}
