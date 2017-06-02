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
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode i = head;
        while (i != null) {
            if (!map.containsKey(i)) {
                map.put(i, new RandomListNode(i.label));
            }
            if(i.random != null && !map.containsKey(i.random)) {
                map.put(i.random, new RandomListNode(i.random.label));
            }
            i = i.next;
        }
        i = head;
        while (i != null) {
            map.get(i).next = map.get(i.next);
            if (i.random != null) {
                map.get(i).random = map.get(i.random);
            }
            i = i.next;
        }
        return map.get(head);
    }
}
