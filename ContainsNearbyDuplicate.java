package leetCodeJava;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class ContainsNearbyDuplicate {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        
    	// solution 1
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	for (int i=0; i<nums.length; i++)
    	{
    		if (map.containsKey(nums[i]))
    		{
    			if (i-map.get(nums[i]) <= k) return true;
    		}
    		
    		map.put(nums[i], i); //map.put(key, value) return previous value of key if map contains key 
    	}
    		
    	return false;
    	
    	// solution 2 sliding window
//    	Set<Integer> set = new HashSet<> ();
//    	
//    	for (int i=0; i<nums.length; i++)
//    	{
//    		if (i > k) set.remove(nums[i-k-1]);
//    		if (!set.add(nums[i])) return true;
//    		System.out.println(set);
//    	}
//    	
//    	return false;
    }
}
