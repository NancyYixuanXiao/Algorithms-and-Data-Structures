package leetCodeJava;

import java.util.*;

public class CountSmaller {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, 0);
        }
        int[] temp = new int [nums.length];
        mergeSort(nums, 0, nums.length - 1, temp, map);
        for (int i = 0; i < nums.length; i++) {
            res.add(map.get(i));
        }
        return res;
    }
    private void mergeSort(int[] nums, int start, int end, int[] temp, Map<Integer, Integer> map) {
        if (start == end) {
            return;
        }
        mergeSort(nums, start, (start + end) / 2, temp, map);
        mergeSort(nums, 1 + (start + end) / 2, end, temp, map);
        merge(nums, start, end, temp, map);
    }
    private void merge(int[] nums, int start, int end, int[] temp, Map<Integer, Integer> map) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        int i = start, j = mid + 1, index = start; 
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
            	System.out.println("reverse pair: " + nums[i] + " " + nums[j]);
                if (i == start) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, map.get(i-1) + 1);
                }
                System.out.println("map" + map);
                temp[index++] = nums[j++];
            }
        }
        while (i <= mid) {
        	if (i > start) {
        		map.put(i, map.get(i-1) + 1);
            }
        	System.out.println("map" + map);
            temp[index++] = nums[i++];
        }
        while (j <= end) {
            temp[index++] = nums[j++];
        }
        for (int k = start; k <= end; k++) {
            nums[k] = temp[k];
        }
    }
}
