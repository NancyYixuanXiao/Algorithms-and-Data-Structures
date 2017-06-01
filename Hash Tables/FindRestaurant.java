public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        Map<Integer, List<String>> common = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int j = map.get(list2[i]);
                if (!common.containsKey(i + j)) {
                    common.put(i + j, new ArrayList<String>());
                }
                common.get(i + j).add(list2[i]);
                if (i + j < min) {
                    min = i + j;
                }
            }
        }
        return common.get(min).toArray(new String[0]);
    }
}
