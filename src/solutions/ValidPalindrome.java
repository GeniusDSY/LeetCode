package solutions;

/**
 * @author :DengSiYuan
 * @date :2020/3/1 21:00
 * @desc :125.验证回文字符串
 * 【题目】
 *      给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 【说明】
 *      本题中，我们将空字符串定义为有效的回文串。
 * 【示例】
 *      输入: "A man, a plan, a canal: Panama"
 *      输出: true
 *
 *      输入: "race a car"
 *      输出: false
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int length = s.length();
        if (length == 0){
            return true;
        }
        char[] chars = s.toLowerCase().toCharArray();
        int j = length - 1;
        for (int i = 0; i < j;) {
            if (!Character.isLetterOrDigit(chars[i])){
                i++;
            }else if (!Character.isLetterOrDigit(chars[j])){
                j--;
            }else {
                if (chars[i] != chars[j]){
                    return false;
                }
                i++;j--;
            }
        }
        return true;
    }
}
