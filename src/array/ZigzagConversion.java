package array;

/**
 * @author :DengSiYuan
 * @date :2019/10/8 21:21
 * @desc : 6.Z字形变换
 * 【题目描述】
 *      将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *      比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *          L   C   I   R
 *          E T O E S I I G
 *          E   D   H   N
 *      之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *      请你实现这个将字符串进行指定行数变换的函数：
 *          string convert(string s, int numRows);
 *【示例】
 *      输入: s = "LEETCODEISHIRING", numRows = 3
 *      输出: "LCIRETOESIIGEDHN"
 *
 *      输入: s = "LEETCODEISHIRING", numRows = 4
 *      输出: "LDREOEIIECIHNTSG"
 *      解释
 *          L     D     R
 *          E   O E   I I
 *          E C   I H   N
 *          T     S     G
 */
public class ZigzagConversion {

    /**
     * 【想法】
     *      将字符串变成字符串数组装入到一个二维数组中，遇到该为空的地方赋值为空，最后横向读出即可
     * @param s
     * @param numRows
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(N^2)
     */
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        char[] chars = s.toCharArray();
        char[][] newChars = new char[numRows][s.length()];
        int a = 0,b= 0;
        for (int i = 0,j = 0,m = 0; i < numRows && m < s.length();i++){
            int remain = j % (numRows - 1);
            if (remain != 0 && i + remain != numRows - 1){
                newChars[i][j] = ' ';
            }else {
                newChars[i][j] = chars[m++];
            }
            if (i / (numRows-1) > 0){
                j++;
                i = -1;
                b++;
            }
            if (m >= s.length()){
                a = i;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < newChars.length; i++) {
            for (int j = 0; j < newChars[0].length; j++) {
                if(newChars[i][j] != '\0'){
                    stringBuilder.append(newChars[i][j]);
                }
            }
        }
        return stringBuilder.toString().replace(" ","");
    }

    /**
     * @param s
     * @param numRows
     * @return
     */
    public String convert1(String s, int numRows) {
        if (s == null || s.length() <= numRows || numRows == 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        int bu = 2 * (numRows - 1);
        int index = 0;
        char[] result = new char[chars.length];
        for (int i = 0; i < numRows; i++) {
            int j = 0;
            while (j + i< chars.length) {
                result[index++] = chars[j+ i];
                if (i > 0 && i < numRows - 1 && j + bu - i < chars.length) {
                    result[index++] = chars[j + bu - i];

                }
                j += bu;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        ZigzagConversion conversion = new ZigzagConversion();
        String s = "PAYPALISHIRING";
        long start = System.nanoTime();
        String result = conversion.convert(s,3);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        System.out.println(result);
        start = System.nanoTime();
        result = conversion.convert1(s,3);
        end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        System.out.println(result);
    }

}
