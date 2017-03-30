package leetCodeJava;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        
    	// solution 1 time complexity O(nlgn)
//    	Arrays.sort(nums);
//    	
//    	for (int i=1; i<nums.length; i++)
//    	{
//    		if (nums[i] == nums[i-1]) return true;
//    	}
//    	
//    	return false;
    	
    	// solution 2 time complexity O(n)
    	Set<Integer> set = new HashSet<> ();
    	
    	for (int num : nums)
    	{
    		if (set.contains(num)) return true;
    		
    		set.add(num);
    	}
    	
    	return false;
    }
}
