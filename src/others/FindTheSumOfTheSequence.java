package others;

import java.util.Scanner;

/**
 * @author :DengSiYuan
 * @date :2020/9/17 9:37
 * @desc : 求数列的和
 * 【题目】
 *      数列的定义如下： 数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
 * 【输入描述】
 *      输入数据有多组，每组占一行，由两个整数n（n<10000）和m(m<1000)组成，n和m的含义如前所述。
 * 【输出描述】
 *      对于每组输入数据，输出该数列的和，每个测试实例占一行，要求精度保留2位小数。
 * 【样例输入】
 *      81 4
 *      2 2
 * 【样例输出】
 *      94.73
 *      3.41
 */
public class FindTheSumOfTheSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            double n = scanner.nextInt();
            double m = scanner.nextInt();
            double sum = 0;
            for (int i = 0; i < m; i++) {
                sum += n;
                n = Math.sqrt(n);
            }
            System.out.printf("%.2f\n", sum);
        }
    }

}
