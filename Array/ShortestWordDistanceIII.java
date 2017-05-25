public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int pos1 = -1, pos2 = -1;
        boolean same = word1.equals(word2);
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (same) {
                    pos1 = pos2;
                    pos2 = i;
                } else {
                    pos1 = i;
                }
            } else if (words[i].equals(word2)) {
                pos2 = i;
            }
            if (pos1 != -1 && pos2 != -1) {
                res = Math.min(res, Math.abs(pos1 - pos2));
            } 
        }
        return res;
    }
}
