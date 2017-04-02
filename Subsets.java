package leetCodeJava;

import java.util.List;
import java.util.ArrayList;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        
    	// solution 1
    	List<List<Integer>> ans = new ArrayList<> ();
    	ans.add(new ArrayList<> ());
    	
    	for (int i=0; i<nums.length; i++)
    	{
    		ArrayList<Integer> tmp = new ArrayList<Integer> ();
    		tmp.add(nums[i]);
    		ans.add(tmp);
    		int size = ans.size();
    		
    		for (int j=1; j<size-1; j++) ans.add(combine(ans.get(j), ans.get(size-1)));
    	}

    	return ans;

    }
    
    public static ArrayList<Integer> combine(List<Integer> list1, List<Integer> list2)
    {
    	ArrayList<Integer> res = new ArrayList<>();
    	
    	for (int i=0; i<list1.size(); i++) res.add(list1.get(i));
    	
    	for (int i=0; i<list2.size(); i++) res.add(list2.get(i));

    	return res;
    }
}
