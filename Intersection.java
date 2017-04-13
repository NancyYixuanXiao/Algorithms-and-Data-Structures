package leetCodeJava;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Intersection {

    public static int[] intersection(int[] nums1, int[] nums2) {
        
    	// solution 1
//    	Set<Integer> set = new HashSet<>();
//    	List<Integer> res = new ArrayList<>();
//    	
//    	for (int num : nums1) set.add(num);
//    	
//    	for (int num : nums2)
//    	{
//    		if (set.contains(num)) 
//    		{
//    			res.add(num);
//    			set.remove(num);
//    		}
//    	}
//    	
//    	int[] ans = new int [res.size()];
//    	int i = 0;
//    	for (int n : res) ans[i++] = n;
//    	
//    	return ans;
    	
    	// solution 2
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	
    	int p1 = 0, p2 = 0;
    	Set<Integer> res = new HashSet<>();
    	
    	while (p1 < nums1.length && p2 < nums2.length)
    	{
    		if (nums1[p1] < nums2[p2]) p1++;
    		else if (nums1[p1] > nums2[p2]) p2++;
    		else 
    		{
    			res.add(nums1[p1]);
    			p1++;
    			p2++;
    		}
    	}
    	
    	int[] ans = new int [res.size()];
    	int i = 0;
    	for (int n : res) ans[i++] = n;
    	
    	return ans;
    }
}
