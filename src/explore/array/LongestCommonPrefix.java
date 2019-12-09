package explore.array;

/**
 * @author :DengSiYuan
 * @date :2019/10/29 21:25
 * @desc : 14.最长公共前缀
 * 【题意】
 *      编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 * 【示例】
 *      示例 1:
 *          输入: ["flower","flow","flight"]
 *          输出: "fl"
 *      示例 2:
 *          输入: ["dog","racecar","car"]
 *          输出: ""
 *          解释: 输入不存在公共前缀。
 * 【说明】
 *      所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {

    /**
     * 【想法】
     *      1、首先判断传入的字符串数组是否为空，若为空直接返回""
     *      2、找到最短的字符串变成字符数组
     *      3、遍历最短的字符串，判断在其他中按位进行比对，遇到不同就立即跳出，进行返回
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null ||strs.length == 0 ){
            return "";
        }
        String minxStr = strs[0];
        for (String str : strs) {
            minxStr = (str.length() > minxStr.length() ? minxStr : str);
        }
        StringBuilder stringBuilder = new StringBuilder("");
        char[] chars = minxStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean status = false;
            for (String str : strs) {
                if (str.toCharArray()[i] != chars[i]){
                    status = true;
                    break;
                }
            }
            if (!status){
                stringBuilder.append(chars[i]);
            }else {
                break;
            }
        }
        return stringBuilder.toString();
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length==0) {
            return "";
        }
        String prefix=strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix)!=0) {
                prefix=prefix.substring(0, prefix.length()-1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        long start = System.nanoTime();
        String result = prefix.longestCommonPrefix1(new String[]{"flower","flow","flight"});
        long end = System.nanoTime();
        System.out.println(result);
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        start = System.nanoTime();
        result = prefix.longestCommonPrefix2(new String[]{"flower","flow","flight"});
        end = System.nanoTime();
        System.out.println(result);
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");

    }

}
