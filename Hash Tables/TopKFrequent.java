public class TopKFrequent {
    private class Element implements Comparable<Element>{
        int value;
        int freq;
        public Element(int v, int f) {
            this.value = v;
            this.freq = f;
        }
        public int compareTo(Element e) {
            return e.freq - this.freq;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Element> list = new ArrayList<>();
        for (int key : map.keySet()) {
            list.add(new Element(key, map.get(key)));
        }
        Collections.sort(list);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(list.get(i).value);
        }
        return res;
    }
}
