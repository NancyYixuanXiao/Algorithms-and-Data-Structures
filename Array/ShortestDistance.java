//P.243
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int pos1 = -1, pos2 = -1;
        int res = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                pos1 = i;
            } 
            if (words[i].equals(word2)) {
                pos2 = i;
            } 
            if (pos1 != -1 && pos2 != -1 && Math.abs(pos1 - pos2) < res) {
                res = Math.abs(pos1 - pos2);
            }
        }
        return res;
    }
}
