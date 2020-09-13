import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 22
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 *
 * @author xyx
 * @date 2020/9/8 12:19
 */
public class GenerateParentheses {

    /**
     * 递归
     * */
    public List<String> generateParenthesis1(int n) {

        List<String> list = new ArrayList<>();
        if (n < 0) {
            return list;
        }
        generateParenthesis(1, 2 * n, "", list);
        return list;

    }

    private void generateParenthesis(int lv, int max, String s, List<String> list) {
        // 中断条件
        if (lv > max) {
            if (isValid(s)) list.add(s);
            return;
        }
        // 本层处理
        // 递归
        generateParenthesis(lv + 1, max, s + "(", list);
        generateParenthesis(lv + 1, max, s + ")", list);
    }

    private boolean isValid(String s) {
        if (s.startsWith(")")) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                if (c == ')') return false;
                stack.push(c);
            } else if (c != stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }




    /**
     * 递归 剪枝
     * */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n < 0) return list;
        generateParenthesis(0, 0, n, "", list);
        return list;
    }

    private void generateParenthesis(int left, int right, int n, String s, List<String> list) {
        // 中断条件
        if (left == n && left == right) {
            list.add(s);
            return;
        }
        if (left < n) generateParenthesis(left + 1, right, n, s + "(", list);
        if (right < left) generateParenthesis(left, right + 1, n, s + ")", list);
    }



    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(4));

    }



}
