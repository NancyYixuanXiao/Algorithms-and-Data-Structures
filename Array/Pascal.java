public class Pascal {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 1; j < i; j++) {
                if (j == 1) {
                    tmp.add(1);
                } else {
                    tmp.add(res.get(i - 2).get(j - 2) + res.get(i - 2).get(j - 1));
                }
            }
            tmp.add(1);
            res.add(tmp);
        }
        return res;
    }
}
