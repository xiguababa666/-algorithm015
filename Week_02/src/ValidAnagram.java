import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 */
public class ValidAnagram {

    public static boolean isAnagram1(String s, String t) {

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        String newS = new String(sArr);
        String newT = new String(tArr);

        return newS.equals(newT);

    }


    public static boolean isAnagram2(String s, String t) {

        Map<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) - 1);
        }
        for (Map.Entry<Character, Integer> e : counter.entrySet()) {
            if (e.getValue() != 0) {
                return false;
            }
        }
        return true;

    }




    // 全小写时适用
    public static boolean isAnagram3(String s, String t) {

        int[] counter = new int[26];
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            int idx = s.charAt(i) % 'a';
            counter[idx] = counter[idx] + 1;
        }

        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            int idx = t.charAt(i) % 'a';
            counter[idx] = counter[idx] - 1;
        }

        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }

        return true;

    }





    public static void main(String[] args) {

        System.out.println(isAnagram2("abc" ,"cbaa"));
    }
}
