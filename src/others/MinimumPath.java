package others;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author :DengSiYuan
 * @date :2019/9/11 19:33
 * @desc : 【小米2019秋招】
 * 输入数据举例：
 *      4   //第一行，代表数组大小
 *      4   //第二行之后的数字，是对数组进行赋值
 *      2
 *      7
 *      6
 * 输出结果：
 *      2   //最小交换次数
 * 最小路径问题，举例说明题意
 *      [4,2,7,6] path = 2+5+1 = 8
 *      [2,4,6,7] path = 2+2+1 = 5
 *      则将第一个数组变换成第二个数组就会得到最短路径，则最少更换几次位置
 *      4<-->2  7<-->6      故输出结果为2
 */
public class MinimumPath {

    /**
     * 想法：
     *      最小路径的数组有两种情况：
     *        （1）正向数组   （2）反向数组
     *      步骤：
     *        （1）通过输入的数组进行排序
     *        （2）正向遍历和逆向遍历排好的数组
     *        （3）分别找到正向第一位和逆向第一位在原数组中的位置
     *        （4）将原数组中的元素进行交换（例如排好序中的索引为0和原数组索引为3的一致，则进行原数组0、3交换），进行计数器++
     *        （5）以此类推，若相同索引元素相同，则不进行计数器操作
     * @return
     */
    public int minimumPath() {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] source1 = new int[size];
        int[] source2 = new int[size];
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            int a = in.nextInt();
            source1[i] = a;
            source2[i] = a;
            arr[i] = a;
        }
        Arrays.sort(arr);
        int count1=0,count2 = 0;
        for (int i = 0, m = arr.length -1 ;i < arr.length && m >=0;i++,m--){
            for (int j = 0; j < arr.length; j++) {
                boolean flag1=false,flag2 = false;
                if (source1[j] == arr[i] && i != j){
                    int temp = source1[j];
                    source1[j] = source1[i];
                    source1[i] = temp;
                    count1++;
                    flag1 = true;
                }
                if (source2[j] == arr[m] && 3-m != j){
                    int temp = source2[j];
                    source2[j] = source2[m];
                    source2[m] = temp;
                    count2++;
                    flag2 = true;
                }
                if (flag1 && flag2){
                    break;
                }
            }
        }
        return count1 < count2 ? count1 : count2 ;
    }

    public static void main(String[] args) {
        MinimumPath path = new MinimumPath();
        System.out.println(path.minimumPath());
    }
}
