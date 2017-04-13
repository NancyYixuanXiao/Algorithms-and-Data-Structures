package leetCodeJava;

public class HasCycle {

	public static boolean hasCycle(ListNode head) {
        
		ListNode fast = head, slow = head;
		
		while (fast!=null && fast.next!=null)
		{
			fast = fast.next.next;
			slow = slow.next;
			
			if (slow == fast)
			{
				return true;
			}
		}
		
		return false;
    }

}
