package leetCodeJava;

public class IsPalindromeLinkedList {

	public static boolean isPalindrome(ListNode head) {
        
		// solution 1 not preserving original list
//		ListNode slow = head, fast = head, rev = null;
//		
//		while (fast != null && fast.next != null)
//		{
//			fast = fast.next.next;
//			ListNode tmp = rev;
//			ListNode tmp1 = slow.next;
//			rev = slow;
//			rev.next = tmp;
//			slow = tmp1;
//			
//		}
//		
//		if (fast != null) slow = slow.next;
//		
//		System.out.print("slow ");
//		ListNode.printListNode(slow);
//		System.out.print("rev ");
//		ListNode.printListNode(rev);
//		
//		while (rev!=null && rev.val == slow.val)
//		{
//			rev = rev.next;
//			slow = slow.next;
//		}
//			
//		return true;
		
		// solution 2 preserving original list
		ListNode fast = head, rev = null, tail, tmp, tmp1;
		
		while (fast!=null && fast.next!=null)
		{
			fast = fast.next.next; 
			tmp = rev;
			tmp1 = head.next;
			rev = head;
			rev.next = tmp;
			head = tmp1;
		}
		
		if (fast != null) tail = head.next;
		else tail = head;
		
		boolean ans = true;
		
		while (rev != null)
		{
			ans = ans & (rev.val == tail.val);
			tail = tail.next;
			tmp = head;
			tmp1 = rev.next;
			head = rev;
			head.next = tmp;
			rev = tmp1;
		}
		
		return ans;
    }
}
