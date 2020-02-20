package sword_finger_offer;

/**
 * @author :DengSiYuan
 * @date :2020/2/20 14:37
 * @desc : 面试题05.替换空格
 * 【题目】
 *      请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *【示例】
 *      输入：s = "We are happy."
 *      输出："We%20are%20happy."
 *【限制】
 *      0 <= s 的长度 <= 10000
 */
public class ReplaceSpaces {

    public String replaceSpace1(String s) {
        return s.replaceAll("\\s","%20");
    }

    public String replaceSpace2(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' ')
                builder.append("%20");
            else
                builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
