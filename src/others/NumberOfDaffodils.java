package others;

import java.util.Scanner;

/**
 * @author :DengSiYuan
 * @date :2020/9/17 9:59
 * @desc : 水仙花数
 * 【题目】
 *      春天是鲜花的季节，水仙花就是其中最迷人的代表，数学上有个水仙花数，他是这样定义的： “水仙花数”是指一个三位数，它的各位数字的立方和等于其本身，比如：153=1^3+5^3+3^3。 现在要求输出所有在m和n范围内的水仙花数。
 * 【输入描述】
 *      输入数据有多组，每组占一行，包括两个整数m和n（100<=m<=n<=999）。
 * 【输出描述】
 * 对于每个测试实例，要求输出所有在给定范围内的水仙花数，就是说，输出的水仙花数必须大于等于m,并且小于等于n，如果有多个，则要求从小到大排列在一行内输出，之间用一个空格隔开; 如果给定的范围内不存在水仙花数，则输出no; 每个测试实例的输出占一行。
 * 【样例输入】
 *      100 120
 *      300 380
 * 【样例输出】
 *      no
 *      370 371
 */
public class NumberOfDaffodils {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int low = scanner.nextInt();
            int high = scanner.nextInt();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = low; i <= high; i++) {
                int a = i % 10;//求个位数
                int b = (i / 10) % 10;//求十位数
                int c = i / 100;//求百位数
                if (i == a * a * a + b * b * b + c * c * c) {
                    stringBuilder.append(i).append(" ");
                }
            }
            if (stringBuilder.length() == 0){
                System.out.println("no");
            } else {
                System.out.println(stringBuilder.toString());
            }
        }
    }

}
