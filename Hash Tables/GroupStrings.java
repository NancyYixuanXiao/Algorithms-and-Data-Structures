public class GroupStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            String key = getShift(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            } 
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            res.add(new ArrayList<>(map.get(key)));
        }
        return res;
    }
    public String getShift(String str) {
        if (str.charAt(0) == 'a') {
            return str;
        } 
        StringBuilder res = new StringBuilder("a");
        int diff = str.charAt(0) - 'a';
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c - 'a' < diff) {
                res.append((char) (c + 26 - diff));
            } else {
                res.append((char) (c - diff));
            }
        }
        return res.toString();
    }
}
