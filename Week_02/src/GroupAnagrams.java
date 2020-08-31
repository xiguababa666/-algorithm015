
import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 */
public class GroupAnagrams {


    public static List<List<String>> groupAnagrams1(String[] strs) {

        Map<String, List<String>> map = new HashMap<>(strs.length);
        for (String s : strs) {
            char[] sr = s.toCharArray();
            Arrays.sort(sr);
            List<String> l = map.computeIfAbsent(String.valueOf(sr), v -> new ArrayList<>());
            l.add(s);
        }
        return new ArrayList<>(map.values());

    }



    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>(strs.length);
        for (String s : strs) {


            int[] counter = new int[26];

            for (int i = 0; i < s.length(); i++) counter[s.charAt(i) - 'a']++;

            List<String> l = map.computeIfAbsent(new String(counter, 0, 26), v -> new ArrayList<>());
            l.add(s);
        }
        return new ArrayList<>(map.values());

    }




    public static void main(String[] args) {

        List<List<String>> l = groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});

        System.out.println(l);

    }


}
