package leetCodeJava;

import java.util.ArrayList;
import java.util.List;

public class ThreeSumClosest {

    private int minDiff = Integer.MAX_VALUE;
    private boolean isLess = false;
    public int threeSumClosest(int[] nums, int target) {
        helper(nums, 0, target, new ArrayList<Integer> ());
        if (isLess) {
            return target - minDiff;
        }
        return target + minDiff;
    }
    private void helper(int[] nums, int startIndex, int target, List<Integer> subset) {
        for (int i = 0; i < subset.size(); i++) {
        	System.out.print(subset.get(i) + " ");
        }
        System.out.print("\n");
    	if (subset.size() == 3) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += subset.get(i);
            }
            System.out.println("current sum: " + sum);
            if (Math.abs(sum - target) < minDiff) {
                minDiff = Math.abs(sum - target);
                if (sum < target) {
                    isLess = true;
                } else {
                	isLess = false;
                }
                System.out.println("minDiff: " + minDiff + " isLess: " + isLess);
            }
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(nums, i+1, target, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
