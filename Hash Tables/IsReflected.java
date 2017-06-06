public class IsReflected {
    public boolean isReflected(int[][] points) {
        Set<String> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] p : points) {
            set.add(toString(p));
            min = Math.min(min, p[0]);
            max = Math.max(max, p[0]);
        }
        int sum = min + max;
        for (String str : set) {
            String[] point = str.split(",");
            int x = Integer.parseInt(point[0]);
            int y = Integer.parseInt(point[1]);
            String sym = (sum - x) + "," + y;
            if (!set.contains(sym)) {
                return false;
            }
        }
        return true;
    }
    public String toString(int[] point) {
        return point[0] + "," + point[1];
    }
}
