/**
 * 387. 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * @author xyx
 * @date 2020/11/1 19:21
 */
public class LeetCode387 {

    public int firstUniqChar(String s) {
        if (s == null) return -1;
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c - 'a']++;
        }
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map[c - 'a'] == 1) {
                return j;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        //System.out.println(new LeetCode387().firstUniqChar("leetcode"));
        //System.out.println(new LeetCode387().firstUniqChar("loveleetcode"));
        System.out.println(new LeetCode387().firstUniqChar(null));
    }

}
