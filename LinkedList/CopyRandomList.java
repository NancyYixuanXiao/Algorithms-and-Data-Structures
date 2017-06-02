/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }
    public void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode newHead = new RandomListNode(head.label);
            RandomListNode next = head.next;
            head.next = newHead;
            newHead.next = next;
            head = next;
        }
    }
    public void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    public RandomListNode splitList(RandomListNode head) {
        RandomListNode newHead = head.next;
        while (head != null) {
            RandomListNode next = head.next.next;
            RandomListNode tmpHead = head.next;
            head.next = next;
            tmpHead.next = next == null ? null : next.next;
            head = next;
        }
        return newHead;
    }
}
