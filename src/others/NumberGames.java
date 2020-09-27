package others;

import java.util.Scanner;

/**
 * @author :DengSiYuan
 * @date :2020/9/20 10:17
 * @desc :
 * 【题目描述】
 *      小团想要编写一个程序，希望可以统计在M和N之间（M<N，且包含M和N）有多少个六位数ABCDEF满足以下要求：
 *      (1) ABCDEF这六个数字均不相同，即A、B、C、D、E和F表示六个不同的数字。
 *      (2) AB+CD=EF。即将这个六位数拆成三个两位数，使得第1个和第2个两位数的和等于第3个两位数。
 *      （注意：AB、CD和EF都必须是正常的两位数，因此A、C和E都不能等于0。）
 * 【输入描述】
 *      单组输入。
 *      输入两个六位正整数M和N（M<N），两者之间用空格隔开。
 * 【输出描述】
 *      输出在M到N之间（包含M和N）满足要求的六位数的个数。
 * 【样例输入】
 *      100000 110000
 * 【样例输出】
 *      0
 */
public class NumberGames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int low = scanner.nextInt();
        int high = scanner.nextInt();
        int num = 0;
        if (high > 999999 || low < 100000){
            System.out.println(0);
            return;
        }
        for (int i = low; i <= high; i++) {
            int a = i / 10000;
            int b = i / 100 % 100;
            int c = i % 100;
            boolean[] flag = new boolean[10];
            int temp = i;
            boolean repeat = false;
            while (temp != 0){
                if (flag[temp % 10]){
                    repeat = true;
                    break;
                }
                flag[temp % 10] = true;
                temp /= 10;
            }
            if (!repeat) {
                if (a < 10) {
                    continue;
                }
                if (a + b == c) {
                    num++;
                }
            }
        }
        System.out.println(num);
    }
}
