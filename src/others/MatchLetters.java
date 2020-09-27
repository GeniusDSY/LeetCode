package others;

import java.util.Scanner;

/**
 * @author :DengSiYuan
 * @date :2020/9/20 11:40
 * @desc :
 * 【题目描述】
 *      输入两个字符串的长度，再输入两个字符串。
 *      若能在第一个字符串中顺序找到第二个字符串，则输出"YES",否则"NO".
 *      第二行输出匹配的字母再第一个字符串中的位置之和
 * 【示例】
 *      输入：
 *          6 3
 *          abcdef ace
 *      输出：
 *          Yes
 *          9   (1+3+5)
 */
public class MatchLetters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aLength = scanner.nextInt();
        int bLength = scanner.nextInt();
        String a = scanner.next();
        String b = scanner.next();
        int i = 0, j = 0;
        int sum = 0;
        if (aLength < bLength || aLength > 200000 || bLength == 0 || aLength == 0) {
            System.out.println("No");
            return;
        }
        while (i < bLength && j < aLength) {
            if (b.charAt(i) == a.charAt(j)) {
                i++;
                sum += j;
            }
            j++;
        }
        if (i == bLength){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        System.out.println(sum + bLength);
    }

}
