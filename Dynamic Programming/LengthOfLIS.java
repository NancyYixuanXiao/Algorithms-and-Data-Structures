public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> ends = new ArrayList<>();
        for (int n : nums) {
            binarySearch(ends, n);
        }
        return ends.size();
    }
    public void binarySearch(List<Integer> list, int target) {
        if (list.size() == 0 || target > list.get(list.size() - 1)) {
            list.add(target);
            return;
        }
        int start = 0, end = list.size() - 1, mid;
        while (start < end - 1) {
            mid = (start + end) / 2;
            if (list.get(mid) >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (list.get(start) >= target) {
            list.set(start, target); 
        } else {
            list.set(end, target);
        }
    }
}
