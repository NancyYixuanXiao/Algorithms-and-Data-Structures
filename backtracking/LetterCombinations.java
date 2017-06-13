public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, keys, new StringBuilder(), 0, 0, res);
        return res;
    }
    public void backtrack(String digits, String[] keys, StringBuilder curr, int start, int index, List<String> res) {
        if (curr.length() == digits.length()) {
            res.add(curr.toString());
            return;
        }
        for (int i = start; i < digits.length(); i++) {
            int digit = Character.getNumericValue(digits.charAt(i));
            for (int j = 0; j < keys[digit].length(); j++) {
                curr.append(keys[digit].charAt(j));
                backtrack(digits, keys, curr, i + 1, 0, res);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }
}
