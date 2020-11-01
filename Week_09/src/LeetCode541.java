
/**
 * 541. 反转字符串 II
 * https://leetcode-cn.com/problems/reverse-string-ii/
 *
 * @author xyx
 * @date 2020/11/1 19:30
 */
public class LeetCode541 {

    public String reverseStr(String s, int k) {
        if (s == null) return null;
        char[] arr = s.toCharArray();
        int interval = 2 * k;
        int len = s.length();
        for (int i = 0; i < len; i += interval) {
            int start = i;
            int end = start + k - 1;
            if (end >= len) end = len - 1;
            while (start < end) {
                char tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
                start++;
                end--;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode541().reverseStr("jfkdsjalfkdjslajfdlsajkeiwoqfjo", 8));
    }

}
