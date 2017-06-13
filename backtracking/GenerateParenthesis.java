public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        helper(res, new StringBuilder(), n, n);
        return res;
    }
    public void helper(List<String> res, StringBuilder curr, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(curr.toString());
            return;
        }
        if (left > 0 && left <= right) {
            curr.append("(");
            helper(res, curr, left - 1, right);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (right > 0 && left <= right) {
            curr.append(")");
            helper(res, curr, left, right - 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
