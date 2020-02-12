package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author :DengSiYuan
 * @date :2020/2/3 11:33
 * @desc : 【腾讯2020校招】   逛街
 * 【题目】
 *      小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
 *      小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？
 *      （当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
 * 【输入描述】
 *      输入第一行将包含一个数字n，代表楼的栋数，接下来的一行将包含n个数字wi(1<=i<=n)，代表每一栋楼的高度。
 *          1<=n<=100000;
 *          1<=wi<=100000;
 * 【输出描述】
 *      输出一行，包含空格分割的n个数字vi，分别代表小Q在第i栋楼时能看到的楼的数量。
 *
 * 【输入例子】
 *      6
 *      5 3 8 3 2 5
 *
 * 【输出例子】
 *      3 3 5 4 4 4
 *
 * 【例子说明】
 *      当小Q处于位置3时，他可以向前看到位置2,1处的楼，向后看到位置4,6处的楼，加上第3栋楼，共可看到5栋楼。
 *      当小Q处于位置4时，他可以向前看到位置3处的楼，向后看到位置5,6处的楼，加上第4栋楼，共可看到4栋楼。
 */
public class Shopping {

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(floorNum(num, array));*/
    }

    public static String floorNum(int num,int[] array){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int leftMax = 0;
            int rightMax = 0;
            int maxNum = 0;
            for (int j = i -1; j >= 0; j--) {
                if (array[j] >= leftMax){
                    maxNum++;
                    leftMax = array[j];
                }
            }
            for (int j = i + 1; j < num; j++) {
                if (array[j] >= rightMax){
                    maxNum++;
                    rightMax = array[j];
                }
            }
            result.append(++maxNum + " ");
        }
        return result.deleteCharAt(result.length() - 1).toString();
    }

    public static String floorNum2(int num,int[] array){
        StringBuilder result = new StringBuilder();
        int[] left = new int[num];
        int[] right = new int[num];
        for (int i = 0; i < num; i++) {
            int leftMax = 0;
            int rightMax = 0;
            if (i == 0){
                left[i] = 0;
            }else if (i == num - 1){
                right[i] = 0;
            }else {

            }
        }
        return null;
    }

}
