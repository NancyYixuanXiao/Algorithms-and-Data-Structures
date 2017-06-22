/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class MiniParser {
    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        NestedInteger curr = null;
        Stack<NestedInteger> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
            } else if (s.charAt(i) == ']') {
                if (!stack.empty()) {
                    stack.peek().add(curr);
                    curr = stack.pop();
                }
            } else if (s.charAt(i) != ',') {
                int start = i;
                while (Character.isDigit(s.charAt(i + 1))) {
                    i++;
                }
                curr.add(new NestedInteger(Integer.parseInt(s.substring(start, i + 1))));
            }
            i++;
        }
        return curr;
    }
}
