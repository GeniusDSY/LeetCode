package solutions;

/**
 * @author :DengSiYuan
 * @date :2020/3/1 17:35
 * @desc :387. 字符串中的第一个唯一字符
 * 【题目】
 *      给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 【示例】
 *      s = "leetcode"
 *      返回 0.
 *
 *      s = "loveleetcode",
 *      返回 2.
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar1(String s) {
        int[] letters = new int[27];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            letters[c - 'a']++;
        }
        for (char c : chars) {
            if (letters[c - 'a'] == 1){
                return s.indexOf(c);
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        for (char c : s.toCharArray()){
            if (s.indexOf(c) == s.lastIndexOf(c)){
                return s.indexOf(c);
            }
        }
        return -1;
    }

}
