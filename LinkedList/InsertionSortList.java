/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head.next, newHead = head, next;
        newHead.next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = null;
            newHead = insert(newHead, curr);
            curr = next;
        }
        return newHead;
    }
    public ListNode insert(ListNode head, ListNode node)  {
        if (node.val <= head.val) {
            node.next = head;
            return node;
        }
        ListNode curr = head;
        while (curr != null) {
            if (curr.next == null || (node.val > curr.val && node.val <= curr.next.val)) {
                ListNode next = curr.next;
                curr.next = node;
                node.next = next;
                break;
            }
            curr = curr.next;
        }
        return head;
    }
}
