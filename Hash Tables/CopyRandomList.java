/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode newHead, prev = dummy;
        while (head != null) {
            if (!map.containsKey(head)) {
                newHead = new RandomListNode(head.label);
                map.put(head, newHead);
            } else {
                newHead = map.get(head);
            }
            prev.next = newHead;
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    newHead.random = new RandomListNode(head.random.label);
                    map.put(head.random, newHead.random);
                } else {
                    newHead.random = map.get(head.random);
                }
            }
            head = head.next;
            prev = newHead;
        }
        return dummy.next;
    }
}
