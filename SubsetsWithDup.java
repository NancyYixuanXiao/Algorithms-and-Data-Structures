package leetCodeJava;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsWithDup {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        
    	Arrays.sort(nums);    	
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int size, start, lastEnd = 0;
        List<Integer> curr;
        
        for (int i=0; i<nums.length; i++)
        {
        	size = res.size();
        	curr = new ArrayList<> ();
        	curr.add(nums[i]);
        	start = 1;
        	
        	if (i==0 || nums[i]!=nums[i-1]) res.add(curr);
        	else start = lastEnd;
        	
        	for(int j=start; j<size; j++) res.add(combine(curr, res.get(j)));
        	
        	lastEnd = size;
        }
        
        return res;
    }
    
    public static List<Integer> combine(List<Integer> list1, List<Integer> list2)
    {
    	List<Integer> res = new ArrayList<>();
    	
    	for (int i=0; i<list1.size(); i++) res.add(list1.get(i));
    	for (int i=0; i<list2.size(); i++) res.add(list2.get(i));
    	
    	return res;
    }
}
