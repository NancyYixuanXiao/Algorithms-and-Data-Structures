package leetCodeJava;

public class ListNode {
	
	int val;
	ListNode next;
	
	ListNode(int x) 
	{ 
		val = x; 
	}
	
	public static void printListNode(ListNode head)
	{
		while (head != null && head.next != null)
		{
			System.out.print(Integer.toString(head.val) + "->");
			head = head.next;
		}
		
		if (head != null)
		{
			System.out.println(Integer.toString(head.val));
		}
	}
}
