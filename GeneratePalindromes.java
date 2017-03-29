package leetCodeJava;
import java.util.*;
public class GeneratePalindromes {

    public List<String> generatePalindromes(String s) {
        List<StringBuilder> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return new ArrayList<String> ();
        }
        boolean odd = false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        List<Character> panlindromeHalf = new ArrayList<>();
        String center = "";
        for (char c : map.keySet()) {
            if (!odd && map.get(c) % 2 != 0) {
                odd = true;
                center = String.valueOf(c);
            } else if (odd && map.get(c) % 2 != 0) {
                return new ArrayList<String> ();
            }  
            for (int t = 0; t < map.get(c)/2; t++) {
                panlindromeHalf.add(c);
            }
        }
        System.out.println("panlindromeHalf: " + panlindromeHalf);
        boolean[] visited = new boolean [panlindromeHalf.size()];
        dfsHelper(panlindromeHalf, visited, new StringBuilder(), result);
        System.out.println("result: " + result);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            StringBuilder sb = result.get(i);
            String temp = sb.toString() + center + sb.reverse().toString();
            System.out.println("sb: " + sb);
            System.out.println("temp: " + temp);
            res.add(temp);
        }
        return res;
    }
    private void dfsHelper(List<Character> c, boolean[] visited, StringBuilder sb, List<StringBuilder> result) {
        if (sb.length() == c.size()) {
            result.add(new StringBuilder(sb));
        }
        for (int i = 0; i < c.size(); i++) {
            if ((i > 0 && c.get(i - 1) == c.get(i) && visited[i - 1]) || visited[i]) {
                continue;
            }
            sb.append(c.get(i));
            visited[i] = true;
            dfsHelper(c, visited, sb, result);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
}
