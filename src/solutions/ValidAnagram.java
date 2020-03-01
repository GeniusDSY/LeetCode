package solutions;

/**
 * @author :DengSiYuan
 * @date :2020/3/1 18:28
 * @desc :242. 有效的字母异位词
 * 【题目】
 *      给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 【示例】
 *      输入: s = "anagram", t = "nagaram"
 *      输出: true
 *
 *      输入: s = "rat", t = "car"
 *      输出: false
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int[] letters = new int[27];
        if(s.length() != t.length()){
            return false;
        }
        char[] chars = s.toCharArray(),chart = t.toCharArray();
        for(char c : chars){
            letters[c - 'a']++;
        }
        for(char c : chart){
            if(letters[c - 'a']-- <= 0){
                return false;
            }
        }
        return true;
    }

}
