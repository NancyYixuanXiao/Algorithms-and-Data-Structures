package leetCodeJava;

public class CanConstruct {

    public static boolean canConstruct(String ransomNote, String magazine) {
        
int[] v = new int [26]; // only letters
        
        for (char c : magazine.toCharArray()) v[c-'a']++;
        
        for (char c : ransomNote.toCharArray())
        {
            if (--v[c-'a'] < 0) return false;
        }
        
        return true;
    }
}
