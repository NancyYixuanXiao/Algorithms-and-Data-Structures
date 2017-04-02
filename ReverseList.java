package leetCodeJava;

public class ReverseList {
	
	public static ListNode reverseList(ListNode head) {
        
		// my solution
//		ListNode prev = null, tmp = null, next = null;
//				
//		while (head != null)
//		{
//			tmp = prev;
//			next = head.next;
//			prev = head;
//			prev.next = tmp;
//			head = next;
//			
//		}
//		return prev;
		
		// iterative solution
//		ListNode prev = null;
//		ListNode curr = head;
//		ListNode next;
//		
//		while (curr != null)
//		{
//			next = curr.next;
//			curr.next = prev;
//			prev = curr;
//			curr = next;
//		}
//		
//		return prev;
		
		// recursive solution
		if (head==null || head.next==null) return head;
		
		ListNode p = reverseList(head.next);
		
//		System.out.print("current head: ");
//		ListNode.printListNode(head);
		
		head.next.next = head;
		head.next = null;
		
//		System.out.print("current list: ");
//		ListNode.printListNode(p);
		
		return p;
    }
}
