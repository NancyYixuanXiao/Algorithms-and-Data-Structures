/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = null;
        while (!stack1.empty() || !stack2.empty() || carry == 1) {
            int d1 = stack1.empty() ? 0 : stack1.pop();
            int d2 = stack2.empty() ? 0 : stack2.pop();
            int d = (d1 + d2 + carry) % 10;
            carry = (d1 + d2 + carry) / 10;
            ListNode tmp = new ListNode(d);
            tmp.next = head;
            head = tmp;
        }
        return head;
    }
}
