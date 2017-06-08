public class IntToRoman {
    public String intToRoman(int num) {
        int[] nums = {1, 5, 10, 50, 100, 500, 1000};
        String romans = "IVXLCDM";
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            map.put(nums[i], romans.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        int i = nums.length - 1;
        while (num != 0) {
            int tmp = num / nums[i];
            if (tmp < 4) {
                for (int t = 0; t < tmp; t++) {
                    res.append(map.get(nums[i]));
                }
            } else if (tmp == 4) {
                res.append(map.get(nums[i]));
                res.append(map.get(nums[i + 1]));
            } else if (tmp < 9) {
                res.append(map.get(nums[i + 1]));
                for (int t = 0; t < tmp - 5; t++) {
                    res.append(map.get(nums[i]));
                }
            } else {
                res.append(map.get(nums[i]));
                res.append(map.get(nums[i + 2]));
            }
            num %= nums[i];
            i -= 2;
        }
        return res.toString();
    }
}
