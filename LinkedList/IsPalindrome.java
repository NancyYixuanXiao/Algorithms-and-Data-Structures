/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev = null, next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        next = prev;
        prev = slow;
        if (fast != null) {
            slow = slow.next;
        }
        fast = next;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            next = fast.next;
            fast.next = prev;
            prev = fast;
            fast = next;
            slow = slow.next;
        }
        return true;
    }
}
