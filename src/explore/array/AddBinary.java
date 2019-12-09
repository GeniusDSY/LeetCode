package explore.array;

import java.math.BigInteger;

/**
 * @author :DengSiYuan
 * @date :2019/12/9 11:56
 * @desc : 67.二进制求和
 * 【题目】
 *      给定两个二进制字符串，返回他们的和（用二进制表示）。
 *      输入为非空字符串且只包含数字 1 和 0。
 * 【示例】
 *      输入: a = "11", b = "1"
 *      输出: "100"
 *
 *      输入: a = "1010", b = "1011"
 *      输出: "10101"
 */
public class AddBinary {

    public String addBinary1(String a, String b) {
        int matchSize = a.length() - b.length();
        if (matchSize > 0) {
            for (int i = 0; i < matchSize; i++) {
                b = '0' + b;
            }
        } else {
            for (int i = 0; i < -matchSize; i++) {
                a = '0' + a;
            }
        }

        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();

        int exceed = 0;
        for (int i = 0; i < charA.length; i++) {
            int sum = charA[charA.length - 1 - i] + charB[charA.length - 1 - i] - '0' * 2 + exceed;
            charA[charA.length - 1 - i] = (char) ('0' + (sum % 2));
            exceed = sum / 2;
        }
        return exceed == 0 ? new String(charA) : "1" + new String(charA);
    }

    public String addBinary2(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int ca = 0;
        for (int i = a.length() - 1, j= b.length() - 1;i >= 0 || j>=0 ;i--,j--) {
            int sum = ca;
            sum = sum + (i >= 0 ? a.charAt(i) - '0' : 0);
            sum = sum + (j >= 0 ? b.charAt(j) - '0' : 0);
            sb.append(sum % 2);
            ca = sum /2;
        }
        if (ca == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }

    public String addBinary3(String a, String b) {
        return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
    }

}
