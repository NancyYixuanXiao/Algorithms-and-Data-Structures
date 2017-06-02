public class FindRepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) {
            return new ArrayList<String>();
        }
        Set<String> repeated = new HashSet<>();
        Set<String> unseen = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            if (!unseen.add(sub)) {
                repeated.add(sub);
            }
        }
        return new ArrayList<String>(repeated);
    }
}
