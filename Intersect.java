package leetCodeJava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList; 

public class Intersect {

    public static int[] intersect(int[] nums1, int[] nums2) {
        
    	// solution 1 two-pointer
//    	Arrays.sort(nums1);
//    	Arrays.sort(nums2);
//    	int p1 = 0, p2 = 0;
//    	List<Integer> res = new ArrayList<>();
//    	
//    	while (p1 < nums1.length && p2 < nums2.length)
//    	{
//    		if (nums1[p1] < nums2[p2]) p1++;
//    		else if (nums1[p1] > nums2[p2]) p2++;
//    		else 
//    		{
//    			res.add(nums1[p1]);
//    			p1++;
//    			p2++;
//    		}
//    	}
//    	
//    	int i = 0;
//    	int[] ans = new int [res.size()];
//    	for (int n : res) ans[i++] = n;
//    	
//    	return ans;
    	
    	// HashMap solution: if nums2 cannot fit in memory, store nums1 in HashMap
    	Map<Integer, Integer> map1 = new HashMap<>();
    	List<Integer> res = new ArrayList<>();
    	
    	for (int num : nums1)
    	{
    		if (map1.containsKey(num)) map1.put(num, map1.get(num)+1);
    		else map1.put(num, 1);
    	}
    	
    	for (int num : nums2)
    	{
    		if (!map1.containsKey(num) || map1.get(num)==0) continue;
    		else
    		{
    			res.add(num);
    			map1.put(num, map1.get(num)-1);
    		}
    	}
    	
    	int[] ans = new int [res.size()];
    	int i = 0;
    	for (int num : res) ans[i++] = num;
    	
    	return ans;
    	
    }
}
