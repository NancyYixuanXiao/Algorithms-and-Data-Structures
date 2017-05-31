public class IntersectII {
    public int[] intersectII(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> intersect = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < nums1.length; i++) {
            int tmp = binarySearch(nums2, nums1[i], start);
            if (tmp != -1) {
                intersect.add(nums1[i]);
                start = tmp + 1;
            }
        }
        int[] res = new int[intersect.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = intersect.get(i);
        }
        return res;
    }
    public int binarySearch(int[] nums, int target, int startPos) {
        if (nums == null || nums.length == 0 || startPos >= nums.length) {
            return -1;
        }
        int start = startPos, end = nums.length - 1, mid;
        while (start < end - 1) {
            mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
