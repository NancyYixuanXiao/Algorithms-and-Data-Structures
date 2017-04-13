package leetCodeJava;

public class GetIntersectionNode {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
    	if (headA==null || headB==null) return null;
    	
    	ListNode pa = headA, pb = headB;
    	
    	while (pa != pb)
    	{   
    		pa = pa==null ? headB : pa.next;
    		pb = pb==null ? headA : pb.next;
    	}
    	
    	return pa;
    }
}
