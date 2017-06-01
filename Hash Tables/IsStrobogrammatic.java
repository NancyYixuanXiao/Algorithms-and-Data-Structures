public class IsStrobogrammatic {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        String num1 = "";
        for (char c : num.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            num1 = map.get(c) + num1;
        }
        return num.equals(num1);
    }
}
