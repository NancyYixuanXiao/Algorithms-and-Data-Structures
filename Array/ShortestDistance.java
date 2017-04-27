//P.243
public class ShortestDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int pos1 = -1;
        int res = words.length;
        for (int i = 0; i < word.length; i++) {
            if (words[i].equals(word1)) {
                pos1 = i;
            } else if (pos1 != -1 && words[i].equals(word2)) {
                if (res > Math.abs(pos1 - i)) {
                    res = Math.abs(pos1 - i);
                }
            }
        }
        return res;
    }
}
