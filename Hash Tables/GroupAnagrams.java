public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String tmp = new String(chars);
            if (!map.containsKey(tmp)) {
                map.put(tmp, new ArrayList<String>());
            } 
            map.get(tmp).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
