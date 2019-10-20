package array;

/**
 * @author :DengSiYuan
 * @date :2019/10/20 10:24
 * @desc : 10.正则表达式匹配
 * 【题目】
 *      给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *      '.' 匹配任意单个字符
 *      '*' 匹配零个或多个前面的那一个元素
 *      所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 【说明】
 *      s 可能为空，且只包含从 a-z 的小写字母。
 *      p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 【示例】
 *      示例 1:
 *          输入:
 *              s = "aa"
 *              p = "a"
 *          输出: false
 *          解释: "a" 无法匹配 "aa" 整个字符串。
 *      示例 2:
 *          输入:
 *              s = "aa"
 *              p = "a*"
 *          输出: true
 *          解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *      示例 3:
 *          输入:
 *              s = "ab"
 *              p = ".*"
 *          输出: true
 *          解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *      示例 4:
 *          输入:
 *              s = "aab"
 *              p = "c*a*b"
 *          输出: true
 *          解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *      示例 5:
 *          输入:
 *              s = "mississippi"
 *              p = "mis*is*p*."
 *          输出: false
 */
public class RegularExpressionMatching {

    /**
     * 回溯递归
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch1(String s, String p) {
        if (p.isEmpty()){
            return s.isEmpty();
        }

        //判断第一位是否皮配：（1）两个字母相等（2）正则的第一位是'.'
        boolean first_match = (!s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        //正则大于一位，并且，第1为是'*'
        if (p.length() >= 2 && p.charAt(1) == '*'){
            //
            return (isMatch1(s, p.substring(2)) ||
                    (first_match && isMatch1(s.substring(1), p)));
        }
        //开始比较第二位
        else {
            return first_match && isMatch1(s.substring(1), p.substring(1));
        }
    }

    /**
     * 动态规划
     * @param text
     * @param pattern
     * @return
     */
    public boolean isMatch2(String text, String pattern) {
        // 多一维的空间，因为求 dp[len - 1][j] 的时候需要知道 dp[len][j] 的情况，
        // 多一维的话，就可以把 对 dp[len - 1][j] 也写进循环了
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        // dp[len][len] 代表两个空串是否匹配了，"" 和 "" ，当然是 true 了。
        dp[text.length()][pattern.length()] = true;

        // 从 len 开始减少
        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length(); j >= 0; j--) {
                // dp[text.length()][pattern.length()] 已经进行了初始化
                if(i==text.length()&&j==pattern.length()) continue;

                boolean first_match = (i < text.length() && j < pattern.length()
                        && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        RegularExpressionMatching matching = new RegularExpressionMatching();
        String s = "ab";
        String p = ".*";
        boolean result = matching.isMatch1(s,p);
        System.out.println(result);
        result = matching.isMatch1(s,p);
        System.out.println(result);
    }

}
