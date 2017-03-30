package leetCodeJava;

public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        
    	// my solution 
//    	if (head == null) return head;
//    	
//    	ListNode i = head, j;
//    	
//    	while (i!=null && i.next != null)
//    	{
//    		j = i.next;
//    		
//    		while (j!=null && i.val == j.val) j = j.next;
//    		
//    		i.next = j;
//    		i = i.next;
//    	}
//    	
//    	return head;
    	
    	//another solution
    	if (head==null) return head;
    	
    	ListNode curr = head;
    	while (curr.next != null)
    	{
    		if (curr.val == curr.next.val)
    		{
    			curr.next = curr.next.next;
    		}
    		else
    		{
    			curr = curr.next;
    		}
    	}
    	
    	return head;
    }
}
