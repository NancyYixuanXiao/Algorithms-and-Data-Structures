//P.532
public class FindPairs {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                if (k == 0) {
                    if (map.get(num) == 0) {
                        map.put(num, 1);
                    }
                }
                continue;
            }
            int count = 0;
            if (map.containsKey(num - k)) {
                count++;
            }
            if (map.containsKey(num + k)) {
                count++;
            }
            map.put(num, count);
        }
        int res = 0;
        for (int key : map.keySet()) {
            res += map.get(key);
        }
        return res;
    }
}
