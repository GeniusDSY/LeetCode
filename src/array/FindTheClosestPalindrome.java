package array;

import java.util.Arrays;

/**
 * @author :DengSiYuan
 * @date :2019/11/17 16:19
 * @desc : 564.寻找最近的回文数
 * 【题目】
 *      给定一个整数 n ，你需要找到与它最近的回文数（不包括自身）。
 *      “最近的”定义为两个整数差的绝对值最小。
 * 【示例】
 *      输入: "123"
 *      输出: "121"
 * 【注意】
 *      n 是由字符串表示的正整数，其长度不超过18。
 *      如果有多个结果，返回最小的那个。
 */
public class FindTheClosestPalindrome {

    public String mirroring(String s) {
        String x = s.substring(0, (s.length()) / 2);
        return x + (s.length() % 2 == 1 ? s.charAt(s.length() / 2) : "") + new StringBuilder(x).reverse().toString();
    }
    public String nearestPalindromic(String n) {
        if (n.equals("1")) {
            return "0";
        }
        String a = mirroring(n);
        long diff1 = Long.MAX_VALUE;
        diff1 = Math.abs(Long.parseLong(n) - Long.parseLong(a));
        if (diff1 == 0) {
            diff1 = Long.MAX_VALUE;
        }
        StringBuilder s = new StringBuilder(n);
        int i = (s.length() - 1) / 2;
        while (i >= 0 && s.charAt(i) == '0') {
            s.replace(i, i + 1, "9");
            i--;
        }
        if (i == 0 && s.charAt(i) == '1') {
            s.delete(0, 1);
            int mid = (s.length() - 1) / 2;
            s.replace(mid, mid + 1, "9");
        } else {
            s.replace(i, i + 1, "" + (char) (s.charAt(i) - 1));
        }
        String b = mirroring(s.toString());
        long diff2 = Math.abs(Long.parseLong(n) - Long.parseLong(b));


        s = new StringBuilder(n);
        i = (s.length() - 1) / 2;
        while (i >= 0 && s.charAt(i) == '9') {
            s.replace(i, i + 1, "0");
            i--;
        }
        if (i < 0) {
            s.insert(0, "1");
        } else {
            s.replace(i, i + 1, "" + (char) (s.charAt(i) + 1));
        }
        String c = mirroring(s.toString());
        long diff3 = Math.abs(Long.parseLong(n) - Long.parseLong(c));

        if (diff2 <= diff1 && diff2 <= diff3) {
            return b;
        }
        if (diff1 <= diff3 && diff1 <= diff2) {
            return a;
        }
        else {
            return c;
        }
    }

    public static void main(String[] args) {
        FindTheClosestPalindrome palindrome = new FindTheClosestPalindrome();
        System.out.println(palindrome.nearestPalindromic("123"));
    }

}
