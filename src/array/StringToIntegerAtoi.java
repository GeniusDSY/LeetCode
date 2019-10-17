package array;

/**
 * @author :DengSiYuan
 * @date :2019/10/15 20:53
 * @desc : 8.字符串转换整数
 * 【题目】
 *      请你来实现一个 atoi 函数，使其能将字符串转换成整数。首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *      当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空
 * 字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *      该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 【注意】
 *      假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 【说明】
 *      假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,231 − 1]。
 *      如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * 【示例】
 *      示例 1:
 *          输入: "42"
 *          输出: 42
 *      示例 2:
 *          输入: "   -42"
 *          输出: -42
 *          解释: 第一个非空白字符为 '-', 它是一个负号。我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 *      示例 3:
 *          输入: "4193 with words"
 *          输出: 4193
 *          解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 *      示例 4:
 *          输入: "words and 987"
 *          输出: 0
 *          解释: 第一个非空字符是 'w', 但它不是数字或正、负号。因此无法执行有效的转换。
 *      示例 5:
 *          输入: "-91283472332"
 *          输出: -2147483648
 *          解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 因此返回 INT_MIN (−231) 。
 */
public class StringToIntegerAtoi {

    /**
     * 【想法】
     *      1、判断字符串是否为空/长度是否为0
     *      2、去除头部空白字符，并对索引进行++维护
     *      3、判断第一个非空字符是否是要求内的字符，若遇到'+'、'-',对index进行++维护，若为'-'，则进行负数标记
     *      4、从index的位置开始遍历字符数组，不断进行结果*10+取余的操作，若数值大于最大或最小，直接返回最大或最小
     * @param str
     * @return
     * @throws RuntimeException
     */
    public int myAtoi(String str) throws RuntimeException {
        if (str == null || str.length() == 0){
            return 0;
        }
        char[] a = new char[]{'-','+','0','1','2','3','4','5','6','7','8','9'};
        char[] chars = str.toCharArray();
        long result = 0;
        boolean status = false;
        boolean isNegative = false;
        int length = chars.length;
        int index = 0;
        for (char c : chars) {
            if (c == ' '){
                index++;
            }else {
                break;
            }
        }
        if (index >= length){
            return 0;
        }
        for (char c : a) {
            if (chars[index] == c){
                if (chars[index] == '-'){
                    isNegative = true;
                    index++;
                }else if (chars[index] == '+'){
                    index++;
                }
                status = true;
                break;
            }

        }
        if (!status){
            return 0;
        }else {
           while (index < length && chars[index] >= '0' && chars[index] <= '9'){
               result = result * 10 + chars[index] - '0';
               if (isNegative && -result <= Integer.MIN_VALUE){
                   return Integer.MIN_VALUE;
               }
               if (!isNegative && result >= Integer.MAX_VALUE){
                   return Integer.MAX_VALUE;
               }
               index++;
           }
        }
        if (isNegative){
            return (int) -result;
        }else {
            return (int) result;
        }
    }

    public static void main(String[] args) {
        StringToIntegerAtoi atoi = new StringToIntegerAtoi();
        String str = "+1";
        int result = atoi.myAtoi(str);
        System.out.println(result);
    }

}
